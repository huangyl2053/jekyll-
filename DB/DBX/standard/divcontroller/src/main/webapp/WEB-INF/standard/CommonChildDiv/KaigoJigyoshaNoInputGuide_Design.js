var DBX;
(function (DBX) {
    (function (KaigoJigyoshaNoInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnCalc = function () {
                return "onClick_btnCalc";
            };

            Events.onClick_btnSet = function () {
                return "onClick_btnSet";
            };
            return Events;
        })();
        KaigoJigyoshaNoInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoJigyoshaNoInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBX.KaigoJigyoshaNoInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBX.KaigoJigyoshaNoInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoJigyoshaNoInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlPrefecturesCode = function () {
                return new UZA.DropDownList(this.convFiledName("ddlPrefecturesCode"));
            };

            Controls.prototype.ddlJigyoshaKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJigyoshaKubun"));
            };

            Controls.prototype.ddlGunshiCode = function () {
                return new UZA.DropDownList(this.convFiledName("ddlGunshiCode"));
            };

            Controls.prototype.txtTsuban = function () {
                return new UZA.TextBox(this.convFiledName("txtTsuban"));
            };

            Controls.prototype.txtCheckDigit = function () {
                return new UZA.TextBox(this.convFiledName("txtCheckDigit"));
            };

            Controls.prototype.btnCalcCheckDigit = function () {
                return new UZA.Button(this.convFiledName("btnCalcCheckDigit"));
            };

            Controls.prototype.btnCreateJigyoshaNo = function () {
                return new UZA.Button(this.convFiledName("btnCreateJigyoshaNo"));
            };
            return Controls;
        })();
        KaigoJigyoshaNoInputGuide.Controls = Controls;
    })(DBX.KaigoJigyoshaNoInputGuide || (DBX.KaigoJigyoshaNoInputGuide = {}));
    var KaigoJigyoshaNoInputGuide = DBX.KaigoJigyoshaNoInputGuide;
})(DBX || (DBX = {}));
