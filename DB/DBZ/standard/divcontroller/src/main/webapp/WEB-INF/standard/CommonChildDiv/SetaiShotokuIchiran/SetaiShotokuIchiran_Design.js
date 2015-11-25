var DBZ;
(function (DBZ) {
    (function (SetaiShotokuIchiran) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_Saihyoji = function () {
                return "onClick_Saihyoji";
            };

            Events.onClick_chkSetaiIchiranAll = function () {
                return "onClick_chkSetaiIchiranAll";
            };

            Events.onClick_Hikaku = function () {
                return "onClick_Hikaku";
            };

            Events.onClick_SetaiinSentaku = function () {
                return "onClick_SetaiinSentaku";
            };

            Events.onClick_btnRirekiClose = function () {
                return "onClick_btnRirekiClose";
            };
            return Events;
        })();
        SetaiShotokuIchiran.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SetaiShotokuIchiran";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SetaiShotokuIchiran.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SetaiShotokuIchiran.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SetaiShotokuIchiran = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtSetaiIchiranKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSetaiIchiranKijunYMD"));
            };

            Controls.prototype.txtSetaiIchiranKazeiNendo = function () {
                return new UZA.TextBoxFlexibleYear(this.convFiledName("txtSetaiIchiranKazeiNendo"));
            };

            Controls.prototype.ddlSetaiIchiranKazeiNendo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSetaiIchiranKazeiNendo"));
            };

            Controls.prototype.btnSaiHyoji = function () {
                return new UZA.Button(this.convFiledName("btnSaiHyoji"));
            };

            Controls.prototype.txtSetaiIchiranSetaiCode = function () {
                return new UZA.TextBoxSetaiCode(this.convFiledName("txtSetaiIchiranSetaiCode"));
            };

            Controls.prototype.chkSetaiIchiranAll = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSetaiIchiranAll"));
            };

            Controls.prototype.lblSetaiIchiranMsg = function () {
                return new UZA.Label(this.convFiledName("lblSetaiIchiranMsg"));
            };

            Controls.prototype.btnNarabeteHyoji = function () {
                return new UZA.Button(this.convFiledName("btnNarabeteHyoji"));
            };

            Controls.prototype.dgSetaiShotoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgSetaiShotoku"));
            };

            Controls.prototype.dgShotokuRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgShotokuRireki"));
            };

            Controls.prototype.btnRirekiClose = function () {
                return new UZA.Button(this.convFiledName("btnRirekiClose"));
            };
            return Controls;
        })();
        SetaiShotokuIchiran.Controls = Controls;
    })(DBZ.SetaiShotokuIchiran || (DBZ.SetaiShotokuIchiran = {}));
    var SetaiShotokuIchiran = DBZ.SetaiShotokuIchiran;
})(DBZ || (DBZ = {}));
