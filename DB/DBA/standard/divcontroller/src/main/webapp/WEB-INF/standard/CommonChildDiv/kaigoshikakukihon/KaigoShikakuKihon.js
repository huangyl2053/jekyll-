var DBZ;
(function (DBZ) {
    (function (KaigoShikakuKihon) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoShikakuKihon.Controls(fieldName);
            }
            ModeController.prototype.連絡先ボタンを = function () {
                return new Modes.連絡先ボタンを(this.controls);
            };

            ModeController.prototype.被保履歴ボタンを = function () {
                return new Modes.被保履歴ボタンを(this.controls);
            };

            ModeController.prototype.認定履歴ボタンを = function () {
                return new Modes.認定履歴ボタンを(this.controls);
            };
            return ModeController;
        })();
        KaigoShikakuKihon.ModeController = ModeController;

        (function (Modes) {
            var 連絡先ボタンを = (function () {
                function 連絡先ボタンを(controls) {
                    this.controls = controls;
                }
                連絡先ボタンを.prototype.表示する = function () {
                    this.controls.btnRenrakusaki().displayNone = false;
                };

                連絡先ボタンを.prototype.表示しない = function () {
                    this.controls.btnRenrakusaki().displayNone = true;
                };
                return 連絡先ボタンを;
            })();
            Modes.連絡先ボタンを = 連絡先ボタンを;

            var 被保履歴ボタンを = (function () {
                function 被保履歴ボタンを(controls) {
                    this.controls = controls;
                }
                被保履歴ボタンを.prototype.表示する = function () {
                    this.controls.btnHihoRireki().displayNone = false;
                };

                被保履歴ボタンを.prototype.表示しない = function () {
                    this.controls.btnHihoRireki().displayNone = true;
                };
                return 被保履歴ボタンを;
            })();
            Modes.被保履歴ボタンを = 被保履歴ボタンを;

            var 認定履歴ボタンを = (function () {
                function 認定履歴ボタンを(controls) {
                    this.controls = controls;
                }
                認定履歴ボタンを.prototype.表示する = function () {
                    this.controls.btnNinteiRireki().displayNone = false;
                };

                認定履歴ボタンを.prototype.表示しない = function () {
                    this.controls.btnNinteiRireki().displayNone = true;
                };
                return 認定履歴ボタンを;
            })();
            Modes.認定履歴ボタンを = 認定履歴ボタンを;
        })(KaigoShikakuKihon.Modes || (KaigoShikakuKihon.Modes = {}));
        var Modes = KaigoShikakuKihon.Modes;
    })(DBZ.KaigoShikakuKihon || (DBZ.KaigoShikakuKihon = {}));
    var KaigoShikakuKihon = DBZ.KaigoShikakuKihon;
})(DBZ || (DBZ = {}));
