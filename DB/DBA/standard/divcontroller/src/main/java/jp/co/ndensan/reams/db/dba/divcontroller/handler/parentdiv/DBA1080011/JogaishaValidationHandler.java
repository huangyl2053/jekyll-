/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1080011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011.JogaishaTorokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011.dgNenreiTotatshusha_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 資格取得除外者登録の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBA-0440-030 zhangzhiming
 */
public class JogaishaValidationHandler {

    private final JogaishaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div Div
     */
    public JogaishaValidationHandler(JogaishaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 確定するボタン押下の場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        RDate jogaiKaijyoYMD = div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().getValue();
        RDate jogaiTekiyoYMD = div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().getValue();
        if ((jogaiKaijyoYMD == null ? RDate.MAX : jogaiKaijyoYMD).isBefore(jogaiTekiyoYMD == null ? RDate.MIN : jogaiTekiyoYMD)) {
            validationMessages.add(
                    new ValidationMessageControlPair(
                            new JogaishaValidationHandler.RRVMessages(UrErrorMessages.前後関係逆転, "資格除外適用年月日", "資格除外解除年月日"),
                            div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD()
                    ));
        }

        TextBoxShikibetsuCode txtShikibetsuCode = div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode();
        ShikibetsuCode shikibetsuCode = txtShikibetsuCode.getDomain();
        List<ShikibetsuCode> shikibetsuCodeList = createShikibetsuCodeList();
        if (shikibetsuCodeList.contains(shikibetsuCode)) {
            validationMessages.add(
                    new ValidationMessageControlPair(
                            new RRVMessages(UrErrorMessages.設定不可, "同一識別コードが存在する"),
                            txtShikibetsuCode
                    ));
        }

        TextBox txtShikibetsuName = div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName();
        RString shikibetsuName = txtShikibetsuName.getValue();
        if (shikibetsuName == null || shikibetsuName.isEmpty()) {
            validationMessages.add(
                    new ValidationMessageControlPair(
                            new RRVMessages(UrErrorMessages.存在しない, "識別コードに対応する対象者"),
                            txtShikibetsuName
                    ));
        }
        return validationMessages;
    }

    private List<ShikibetsuCode> createShikibetsuCodeList() {
        List<ShikibetsuCode> shikibetsuCodeList = new ArrayList<>();
        List<dgNenreiTotatshusha_Row> dataSource = div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().getDataSource();
        for (dgNenreiTotatshusha_Row row : dataSource) {
            RString rowShikibetsuCode = row.getShikibetsuCode();
            if (rowShikibetsuCode == null || rowShikibetsuCode.isEmpty()) {
                shikibetsuCodeList.add(new ShikibetsuCode(rowShikibetsuCode));
            }
        }
        return shikibetsuCodeList;
    }

    /**
     * 保存するボタンを押下した際の、更新可能チェックを行います。
     *
     * @return 保存データが無いことを示すメッセージ
     */
    public ValidationMessageControlPairs validate更新可能() {
        DataGrid<dgNenreiTotatshusha_Row> dg = div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha();
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(
                new ValidationMessageControlPair(
                        new JogaishaValidationHandler.RRVMessages(UrErrorMessages.保存データなし), dg));
        return validationMessages;
    }

    /**
     * 保存するボタン押下の場合、重複チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs juufukuCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new JogaishaValidationHandler.RRVMessages(
                UrErrorMessages.期間が重複)));
        return validationMessages;
    }

    private static final class RRVMessages implements IValidationMessage {

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
