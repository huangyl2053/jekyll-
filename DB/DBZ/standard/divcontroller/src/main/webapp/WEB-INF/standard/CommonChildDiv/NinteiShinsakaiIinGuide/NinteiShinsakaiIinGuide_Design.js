var DBZ;
(function (DBZ) {
    (function (NinteiShinsakaiIinGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnKensakku = function () {
                return "onClick_btnKensakku";
            };

            Events.onClick_btnClear = function () {
                return "onClick_btnClear";
            };

            Events.onClick_ShinsakaiIinIchiranDate = function () {
                return "onClick_ShinsakaiIinIchiranDate";
            };

            Events.onClick_btnModoru = function () {
                return "onClick_btnModoru";
            };

            Events.onClick_btnSaikensaku = function () {
                return "onClick_btnSaikensaku";
            };
            return Events;
        })();
        NinteiShinsakaiIinGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiShinsakaiIinGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiShinsakaiIinGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiShinsakaiIinGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiShinsakaiIinGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.KensakuJoken = function () {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
            };

            Controls.prototype.KensakuJokenInput = function () {
                return new UZA.Panel(this.convFiledName("KensakuJokenInput"));
            };

            Controls.prototype.txtShinsakaiIinCodeFrom = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShinsakaiIinCodeFrom"));
            };

            Controls.prototype.txtShinsakaiIinCodeTo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShinsakaiIinCodeTo"));
            };

            Controls.prototype.txtShinsakaiIinName = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsakaiIinName"));
            };

            Controls.prototype.ddlSeibetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSeibetsu"));
            };

            Controls.prototype.ddlShinsainShikakuCode = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinsainShikakuCode"));
            };

            Controls.prototype.txtMaxKensu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxKensu"));
            };

            Controls.prototype.btnKensakku = function () {
                return new UZA.Button(this.convFiledName("btnKensakku"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.ShosaiJoken = function () {
                return new UZA.Panel(this.convFiledName("ShosaiJoken"));
            };

            Controls.prototype.lblShozoku = function () {
                return new UZA.Label(this.convFiledName("lblShozoku"));
            };

            Controls.prototype.ddlIryoKikan = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIryoKikan"));
            };

            Controls.prototype.ddlKaigoJigyosha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaigoJigyosha"));
            };

            Controls.prototype.ddlSonotaJigyosha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSonotaJigyosha"));
            };

            Controls.prototype.chkKiken = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKiken"));
            };

            Controls.prototype.chkHaishi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHaishi"));
            };

            Controls.prototype.ShinsakaiIinIchiran = function () {
                return new UZA.Panel(this.convFiledName("ShinsakaiIinIchiran"));
            };

            Controls.prototype.dgShinsakaiIinIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIinIchiran"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnSaikensaku = function () {
                return new UZA.Button(this.convFiledName("btnSaikensaku"));
            };
            return Controls;
        })();
        NinteiShinsakaiIinGuide.Controls = Controls;
    })(DBZ.NinteiShinsakaiIinGuide || (DBZ.NinteiShinsakaiIinGuide = {}));
    var NinteiShinsakaiIinGuide = DBZ.NinteiShinsakaiIinGuide;
})(DBZ || (DBZ = {}));
