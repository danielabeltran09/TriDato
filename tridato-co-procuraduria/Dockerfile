FROM python

ENV FLASK_APP=/scraper/proc.py
EXPOSE 5000

ADD scraper /scraper
RUN pip install -r /scraper/requirements.txt
CMD ["flask", "run"]
