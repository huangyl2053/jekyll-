var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRirekiList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgJutoku = function () {
                return "onSelect_dgJutoku";
            };

            Events.onSelectByDblClick_dgJutoku = function () {
                return "onSelectByDblClick_dgJutoku";
            };

            Events.onSelectByModifyButton_dgJutoku = function () {
                return "onSelectByModifyButton_dgJutoku";
            };

            Events.onSelectByDeleteButton_dgJutoku = function () {
                return "onSelectByDeleteButton_dgJutoku";
            };

            Events.onClick_btnJutokuKakutei = function () {
                return "onClick_btnJutokuKakutei";
            };

            Events.onClick_btnJutokuTorikeshi = function () {
                return "onClick_btnJutokuTorikeshi";
            };
            return Events;
        })();
        JushochiTokureiRirekiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JushochiTokureiRirekiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JushochiTokureiRirekiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgJutoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutoku"));
            };

            Controls.prototype.JutokuInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput"));
            };

            Controls.prototype.JutokuTekiyoInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuTekiyoInput"));
            };

            Controls.prototype.txtTekiyoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            };

            Controls.prototype.txtTekiyoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoTodokedeDate"));
            };

            Controls.prototype.ddlTekiyoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyoJiyu"));
            };

            Controls.prototype.JutokuKaijoInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuKaijoInput"));
            };

            Controls.prototype.txtKaijoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoDate"));
            };

            Controls.prototype.txtKaijoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoTodokedeDate"));
            };

            Controls.prototype.ddlKaijoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijoJiyu"));
            };

            Controls.prototype.btnJutokuKakutei = function () {
                return new UZA.Button(this.convFiledName("btnJutokuKakutei"));
            };

            Controls.prototype.btnJutokuTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnJutokuTorikeshi"));
            };
            return Controls;
        })();
        JushochiTokureiRirekiList.Controls = Controls;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));
