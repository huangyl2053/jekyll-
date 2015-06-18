var DBD;
(function (DBD) {
    (function (NinteiShinseiTodokedesha) {
        var Events = (function () {
            function Events() {
            }
            Events.onChanged_ddlTodokedeDaikoKubun = function () {
                return "onChanged_ddlTodokedeDaikoKubun";
            };

            Events.onClick_btnZenkaiFukusha = function () {
                return "onClick_btnZenkaiFukusha";
            };
            return Events;
        })();
        NinteiShinseiTodokedesha.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiShinseiTodokedesha";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.NinteiShinseiTodokedesha.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.NinteiShinseiTodokedesha.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiShinseiTodokedesha = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlTodokledeDaikoKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTodokledeDaikoKubun"));
            };

            Controls.prototype.btnSetaiIchiran = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSetaiIchiran"));
            };

            Controls.prototype.btnAtenaKensaku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnAtenaKensaku"));
            };

            Controls.prototype.btnZenkaiFukusha = function () {
                return new UZA.Button(this.convFiledName("btnZenkaiFukusha"));
            };

            Controls.prototype.txtJigyoshaCode = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaCode"));
            };

            Controls.prototype.btnJigyoshaGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaGuide"));
            };

            Controls.prototype.txtJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            };

            Controls.prototype.ddlShinseiKankeisha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiKankeisha"));
            };

            Controls.prototype.txtShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            };

            Controls.prototype.txtKanaShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtKanaShimei"));
            };

            Controls.prototype.txtHonninKankeisei = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHonninKankeisei"));
            };

            Controls.prototype.lblHonninKankeiseiMei = function () {
                return new UZA.Label(this.convFiledName("lblHonninKankeiseiMei"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtJusho = function () {
                return new UZA.TextBoxJusho(this.convFiledName("txtJusho"));
            };
            return Controls;
        })();
        NinteiShinseiTodokedesha.Controls = Controls;
    })(DBD.NinteiShinseiTodokedesha || (DBD.NinteiShinseiTodokedesha = {}));
    var NinteiShinseiTodokedesha = DBD.NinteiShinseiTodokedesha;
})(DBD || (DBD = {}));
