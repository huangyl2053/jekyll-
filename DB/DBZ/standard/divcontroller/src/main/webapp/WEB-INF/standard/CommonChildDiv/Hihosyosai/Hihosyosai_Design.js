var DBZ;
(function (DBZ) {
    (function (Hihosyosai) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_Change = function () {
                return "onClick_Change";
            };
            return Events;
        })();
        Hihosyosai.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "Hihosyosai";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.Hihosyosai.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.Hihosyosai.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.Hihosyosai = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblSyutokubi = function () {
                return new UZA.Label(this.convFiledName("lblSyutokubi"));
            };

            Controls.prototype.lblSyutokutodokedebi = function () {
                return new UZA.Label(this.convFiledName("lblSyutokutodokedebi"));
            };

            Controls.prototype.lblSyutokujiyu = function () {
                return new UZA.Label(this.convFiledName("lblSyutokujiyu"));
            };

            Controls.prototype.lblHihokubun = function () {
                return new UZA.Label(this.convFiledName("lblHihokubun"));
            };

            Controls.prototype.lblSyozaiHokensya = function () {
                return new UZA.Label(this.convFiledName("lblSyozaiHokensya"));
            };

            Controls.prototype.lblSotimotoHokensya = function () {
                return new UZA.Label(this.convFiledName("lblSotimotoHokensya"));
            };

            Controls.prototype.lblKyuHokensya = function () {
                return new UZA.Label(this.convFiledName("lblKyuHokensya"));
            };

            Controls.prototype.lblSyoniNichiji = function () {
                return new UZA.Label(this.convFiledName("lblSyoniNichiji"));
            };

            Controls.prototype.txtSyutokuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSyutokuYMD"));
            };

            Controls.prototype.txtSyutokutodokedeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSyutokutodokedeYMD"));
            };

            Controls.prototype.ddlSyutokuJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSyutokuJiyu"));
            };

            Controls.prototype.ddlHihokubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHihokubun"));
            };

            Controls.prototype.ddlSyozaiHokensya = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSyozaiHokensya"));
            };

            Controls.prototype.ddlSotimotoHokensya = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSotimotoHokensya"));
            };

            Controls.prototype.ddlKyuHokensya = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKyuHokensya"));
            };

            Controls.prototype.txtSyoninichiji1 = function () {
                return new UZA.TextBox(this.convFiledName("txtSyoninichiji1"));
            };

            Controls.prototype.lblSosichibi = function () {
                return new UZA.Label(this.convFiledName("lblSosichibi"));
            };

            Controls.prototype.lblSosichiTodokedebi = function () {
                return new UZA.Label(this.convFiledName("lblSosichiTodokedebi"));
            };

            Controls.prototype.lblSosichiJiyu = function () {
                return new UZA.Label(this.convFiledName("lblSosichiJiyu"));
            };

            Controls.prototype.lblSyoninichibi2 = function () {
                return new UZA.Label(this.convFiledName("lblSyoninichibi2"));
            };

            Controls.prototype.txtSosichiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSosichiYMD"));
            };

            Controls.prototype.txtSosichiTodokedeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSosichiTodokedeYMD"));
            };

            Controls.prototype.ddlSosichiJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSosichiJiyu"));
            };

            Controls.prototype.txtSyoninichiji2 = function () {
                return new UZA.TextBox(this.convFiledName("txtSyoninichiji2"));
            };

            Controls.prototype.tabContainerDetail = function () {
                return new UZA.TabContainer(this.convFiledName("tabContainerDetail"));
            };

            Controls.prototype.tabPnlJyusyoti = function () {
                return new UZA.TabPanel(this.convFiledName("tabPnlJyusyoti"));
            };

            Controls.prototype.tabPnlShikaku = function () {
                return new UZA.TabPanel(this.convFiledName("tabPnlShikaku"));
            };

            Controls.prototype.tabPnlShisetu = function () {
                return new UZA.TabPanel(this.convFiledName("tabPnlShisetu"));
            };
            return Controls;
        })();
        Hihosyosai.Controls = Controls;
    })(DBZ.Hihosyosai || (DBZ.Hihosyosai = {}));
    var Hihosyosai = DBZ.Hihosyosai;
})(DBZ || (DBZ = {}));
