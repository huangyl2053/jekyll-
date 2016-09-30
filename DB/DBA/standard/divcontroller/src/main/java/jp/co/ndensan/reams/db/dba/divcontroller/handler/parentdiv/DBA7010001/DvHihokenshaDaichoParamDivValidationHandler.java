/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7010001;

import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010001.DvHihokenshaDaichoParamDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト被保険者台帳のクラスです。
 *
 * @reamsid_L DBA-1610-010 linghuhang
 */
public class DvHihokenshaDaichoParamDivValidationHandler {

    private final DvHihokenshaDaichoParamDiv div;
    private static final RString 住所開始と住所終了 = new RString("住所開始と住所終了");
    private static final RString 行政区開始と行政区終了 = new RString("行政区開始と行政区終了");
    private static final RString 地区１開始と地区１終了 = new RString("地区１開始と地区１終了");
    private static final RString 地区２開始と地区２終了 = new RString("地区２開始と地区２終了");
    private static final RString 地区３開始と地区３終了 = new RString("地区３開始と地区３終了");

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト被保険者台帳Div
     */
    public DvHihokenshaDaichoParamDivValidationHandler(DvHihokenshaDaichoParamDiv div) {
        this.div = div;
    }

    /**
     * 実行するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForAction() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (HizukeChushutsuKubun.基準日.getコード().equals(div.getRadChushutsuKijunBi().getSelectedKey())
            && div.getTxtKijunDate().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.Validate日付必須, div.getTxtKijunDate()));
        }
        if (HizukeChushutsuKubun.範囲.getコード().equals(div.getRadChushutsuHani().getSelectedKey())
            && div.getTxtChushutsuHani() != null
            && div.getTxtChushutsuHani().getFromValue() != null
            && div.getTxtChushutsuHani().getToValue() != null
            && div.getTxtChushutsuHani().getToValue().isBefore(div.getTxtChushutsuHani().getFromValue())) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.Validate日付不正, div.getTxtChushutsuHani()));
        }
        
        /**宛名の住所Check*/
        if (Chiku.住所.getコード().equals(div.getCcdHanyoListAtenaSelect().get地区().getコード())
            && !div.getCcdHanyoListAtenaSelect().get住所開始().isNullOrEmpty()
            && !div.getCcdHanyoListAtenaSelect().get住所終了().isNullOrEmpty()
            && div.getCcdHanyoListAtenaSelect().get住所開始().compareTo(div.getCcdHanyoListAtenaSelect().get住所終了()) > 0) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.Validate大小関係不正住所, div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div()));
        }
        /**宛名の行政区Check*/
        if (Chiku.行政区.getコード().equals(div.getCcdHanyoListAtenaSelect().get地区().getコード())
            && !div.getCcdHanyoListAtenaSelect().get行政区開始().isNullOrEmpty()
            && !div.getCcdHanyoListAtenaSelect().get行政区終了().isNullOrEmpty()
            && div.getCcdHanyoListAtenaSelect().get行政区開始().compareTo(div.getCcdHanyoListAtenaSelect().get行政区終了()) > 0) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.Validate大小関係不正行政区, div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div()));
        }
        /**宛名の地区１Check*/
        if (Chiku.地区.getコード().equals(div.getCcdHanyoListAtenaSelect().get地区().getコード())
            && !div.getCcdHanyoListAtenaSelect().get地区１開始().isNullOrEmpty()
            && !div.getCcdHanyoListAtenaSelect().get地区１終了().isNullOrEmpty()
            && div.getCcdHanyoListAtenaSelect().get地区１開始().compareTo(div.getCcdHanyoListAtenaSelect().get地区１終了()) > 0) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.Validate大小関係不正地区１, div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div()));
        }
        /**宛名の地区２Check*/
        if (Chiku.地区.getコード().equals(div.getCcdHanyoListAtenaSelect().get地区().getコード())
            && !div.getCcdHanyoListAtenaSelect().get地区２開始().isNullOrEmpty()
            && !div.getCcdHanyoListAtenaSelect().get地区２終了().isNullOrEmpty()
            && div.getCcdHanyoListAtenaSelect().get地区２開始().compareTo(div.getCcdHanyoListAtenaSelect().get地区２終了()) > 0) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.Validate大小関係不正地区２, div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div()));
        }
        /**宛名の地区３Check*/
        if (Chiku.地区.getコード().equals(div.getCcdHanyoListAtenaSelect().get地区().getコード())
            && !div.getCcdHanyoListAtenaSelect().get地区３開始().isNullOrEmpty()
            && !div.getCcdHanyoListAtenaSelect().get地区３終了().isNullOrEmpty()
            && div.getCcdHanyoListAtenaSelect().get地区３開始().compareTo(div.getCcdHanyoListAtenaSelect().get地区３終了()) > 0) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.Validate大小関係不正地区３, div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div()));
        }
        return validPairs;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        Validate日付必須(UrErrorMessages.必須, "基準日"),
        Validate日付不正(UrErrorMessages.終了日が開始日以前),
        Validate大小関係不正住所(UrErrorMessages.大小関係が不正, 住所開始と住所終了.toString()),
        Validate大小関係不正行政区(UrErrorMessages.大小関係が不正, 行政区開始と行政区終了.toString()),
        Validate大小関係不正地区１(UrErrorMessages.大小関係が不正, 地区１開始と地区１終了.toString()),
        Validate大小関係不正地区２(UrErrorMessages.大小関係が不正, 地区２開始と地区２終了.toString()),
        Validate大小関係不正地区３(UrErrorMessages.大小関係が不正, 地区３開始と地区３終了.toString());
        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
