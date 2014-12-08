var DBC;
(function (DBC) {
    (function (KogakuServicehiDetail) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KogakuServicehiDetail.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KogakuServicehiDetail";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KogakuServicehiDetail.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KogakuServicehiDetail.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KogakuServicehiDetail = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            };

            Controls.prototype.tabKogakuServicehiDetail = function () {
                return new UZA.TabContainer(this.convFiledName("tabKogakuServicehiDetail"));
            };

            Controls.prototype.tplShinseisha = function () {
                return new UZA.TabPanel(this.convFiledName("tplShinseisha"));
            };

            Controls.prototype.txtShiharaiTotalAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShiharaiTotalAmount"));
            };

            Controls.prototype.txtShinseiRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            };

            Controls.prototype.tplKoza = function () {
                return new UZA.TabPanel(this.convFiledName("tplKoza"));
            };

            Controls.prototype.tplJudgementResult = function () {
                return new UZA.TabPanel(this.convFiledName("tplJudgementResult"));
            };

            Controls.prototype.tplKetteiJoho = function () {
                return new UZA.TabPanel(this.convFiledName("tplKetteiJoho"));
            };
            return Controls;
        })();
        KogakuServicehiDetail.Controls = Controls;
    })(DBC.KogakuServicehiDetail || (DBC.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBC.KogakuServicehiDetail;
})(DBC || (DBC = {}));
