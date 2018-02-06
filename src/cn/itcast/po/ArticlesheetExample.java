package cn.itcast.po;

import java.util.ArrayList;
import java.util.List;

public class ArticlesheetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticlesheetExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andArticleidIsNull() {
            addCriterion("articleid is null");
            return (Criteria) this;
        }

        public Criteria andArticleidIsNotNull() {
            addCriterion("articleid is not null");
            return (Criteria) this;
        }

        public Criteria andArticleidEqualTo(String value) {
            addCriterion("articleid =", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotEqualTo(String value) {
            addCriterion("articleid <>", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThan(String value) {
            addCriterion("articleid >", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThanOrEqualTo(String value) {
            addCriterion("articleid >=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThan(String value) {
            addCriterion("articleid <", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThanOrEqualTo(String value) {
            addCriterion("articleid <=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLike(String value) {
            addCriterion("articleid like", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotLike(String value) {
            addCriterion("articleid not like", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidIn(List<String> values) {
            addCriterion("articleid in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotIn(List<String> values) {
            addCriterion("articleid not in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidBetween(String value1, String value2) {
            addCriterion("articleid between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotBetween(String value1, String value2) {
            addCriterion("articleid not between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeIsNull() {
            addCriterion("article_describe is null");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeIsNotNull() {
            addCriterion("article_describe is not null");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeEqualTo(String value) {
            addCriterion("article_describe =", value, "articleDescribe");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeNotEqualTo(String value) {
            addCriterion("article_describe <>", value, "articleDescribe");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeGreaterThan(String value) {
            addCriterion("article_describe >", value, "articleDescribe");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("article_describe >=", value, "articleDescribe");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeLessThan(String value) {
            addCriterion("article_describe <", value, "articleDescribe");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeLessThanOrEqualTo(String value) {
            addCriterion("article_describe <=", value, "articleDescribe");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeLike(String value) {
            addCriterion("article_describe like", value, "articleDescribe");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeNotLike(String value) {
            addCriterion("article_describe not like", value, "articleDescribe");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeIn(List<String> values) {
            addCriterion("article_describe in", values, "articleDescribe");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeNotIn(List<String> values) {
            addCriterion("article_describe not in", values, "articleDescribe");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeBetween(String value1, String value2) {
            addCriterion("article_describe between", value1, value2, "articleDescribe");
            return (Criteria) this;
        }

        public Criteria andArticleDescribeNotBetween(String value1, String value2) {
            addCriterion("article_describe not between", value1, value2, "articleDescribe");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(Integer value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(Integer value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(Integer value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(Integer value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<Integer> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<Integer> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(Integer value1, Integer value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlIsNull() {
            addCriterion("title_imgurl is null");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlIsNotNull() {
            addCriterion("title_imgurl is not null");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlEqualTo(String value) {
            addCriterion("title_imgurl =", value, "titleImgurl");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlNotEqualTo(String value) {
            addCriterion("title_imgurl <>", value, "titleImgurl");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlGreaterThan(String value) {
            addCriterion("title_imgurl >", value, "titleImgurl");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("title_imgurl >=", value, "titleImgurl");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlLessThan(String value) {
            addCriterion("title_imgurl <", value, "titleImgurl");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlLessThanOrEqualTo(String value) {
            addCriterion("title_imgurl <=", value, "titleImgurl");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlLike(String value) {
            addCriterion("title_imgurl like", value, "titleImgurl");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlNotLike(String value) {
            addCriterion("title_imgurl not like", value, "titleImgurl");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlIn(List<String> values) {
            addCriterion("title_imgurl in", values, "titleImgurl");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlNotIn(List<String> values) {
            addCriterion("title_imgurl not in", values, "titleImgurl");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlBetween(String value1, String value2) {
            addCriterion("title_imgurl between", value1, value2, "titleImgurl");
            return (Criteria) this;
        }

        public Criteria andTitleImgurlNotBetween(String value1, String value2) {
            addCriterion("title_imgurl not between", value1, value2, "titleImgurl");
            return (Criteria) this;
        }

        public Criteria andPubdateIsNull() {
            addCriterion("pubdate is null");
            return (Criteria) this;
        }

        public Criteria andPubdateIsNotNull() {
            addCriterion("pubdate is not null");
            return (Criteria) this;
        }

        public Criteria andPubdateEqualTo(String value) {
            addCriterion("pubdate =", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateNotEqualTo(String value) {
            addCriterion("pubdate <>", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateGreaterThan(String value) {
            addCriterion("pubdate >", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateGreaterThanOrEqualTo(String value) {
            addCriterion("pubdate >=", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateLessThan(String value) {
            addCriterion("pubdate <", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateLessThanOrEqualTo(String value) {
            addCriterion("pubdate <=", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateLike(String value) {
            addCriterion("pubdate like", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateNotLike(String value) {
            addCriterion("pubdate not like", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateIn(List<String> values) {
            addCriterion("pubdate in", values, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateNotIn(List<String> values) {
            addCriterion("pubdate not in", values, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateBetween(String value1, String value2) {
            addCriterion("pubdate between", value1, value2, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateNotBetween(String value1, String value2) {
            addCriterion("pubdate not between", value1, value2, "pubdate");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}