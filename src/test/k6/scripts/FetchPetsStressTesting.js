import http from "k6/http";
import { sleep, check } from "k6";

export const options = {
  discardResponseBodies: true,
    stages: [
      { duration: "15m", target: 250 },
      { duration: "30m", target: 250 },
      { duration: "15m", target: 0 },
    ],
	thresholds: {
		http_req_duration: [{
			threshold: 'p(90)<300',
			abortOnFail: true
		}]
	}
};

export default function () {
	const params = {
		headers: {
			'Content-Type': 'application/json'
		},
	};

  const res = http.get(
    `${__ENV.URL}/api/v3/pet/findByTags?tags=tag1`, params
  );

  sleep(1);

  check(res, {
    "is status 200": (r) => r.status === 200,
  });
}
