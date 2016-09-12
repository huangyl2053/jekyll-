/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.bunshobangoinput;

import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNoHatsubanHoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 文書番号入力Divの操作を行うクラスです。
 */
public class BunshoBangoInputHandler {

    private final BunshoBangoInputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 文書番号入力Div
     */
    public BunshoBangoInputHandler(BunshoBangoInputDiv div) {
        this.div = div;
    }

    /**
     * 共有子Divの初期化を行います。
     *
     * @param 帳票ID 帳票ID
     * @param 基準日 基準日
     * @throws ApplicationException 文書番号が見つからない場合
     */
    public void initialize(ReportId 帳票ID, FlexibleDate 基準日) throws ApplicationException {
        div.getTxtBunshoKigo().clearValue();
        div.getTxtBunshoHeader().clearValue();
        div.getTxtBunshoNo().clearValue();
        div.getTxtBunshoFooter().clearValue();

        if (null == 帳票ID || 帳票ID.isEmpty()) {
            return;
        }

        IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();

        BunshoNo bunshoNo = finder.get文書番号管理(帳票ID, 基準日);
        if (bunshoNo == null) {
            RString errorMessage = new RStringBuilder(new RString("以下の条件に合う文書番号がありません。")).
                    append(new RString("帳票ID：")).
                    append(帳票ID.value()).
                    append(new RString(", 基準日：")).
                    append(new RString(基準日.toString())).
                    toRString();

            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(
                    errorMessage.toString()));
        }
        if (BunshoNoHatsubanHoho.toValue(bunshoNo.get文書番号発番方法()) == BunshoNoHatsubanHoho.固定) {
            div.setMode_DisplayType(BunshoBangoInputDiv.DisplayType.Kotei);
        } else if (BunshoNoHatsubanHoho.toValue(bunshoNo.get文書番号発番方法()) == BunshoNoHatsubanHoho.手入力) {
            div.setMode_DisplayType(BunshoBangoInputDiv.DisplayType.ShudoNyuryoku);
        } else {
            div.setMode_DisplayType(BunshoBangoInputDiv.DisplayType.JidoSaiban);
        }

        div.getTxtBunshoKigo().setValue(bunshoNo.getEdit文書番号記号());
        div.getTxtBunshoHeader().setValue(bunshoNo.getEditヘッダー文字());
        div.getTxtBunshoFooter().setValue(bunshoNo.getEditフッター文字());
        if (BunshoNoHatsubanHoho.toValue(bunshoNo.get文書番号発番方法()) == BunshoNoHatsubanHoho.固定) {
            div.getTxtBunshoNo().setValue(bunshoNo.get文書番号固定文字());
        }
    }

    /**
     * 採番APIを使用して文書番号を取得します。
     *
     * @return RString
     */
    public RString get自動採番文書番号() {

        SubGyomuCode サブ業務コード = ControlDataHolder.getSubGyomuCD();
        CountedItem countedItem = Saiban.get(サブ業務コード, SaibanHanyokeyName.文書番号.get名称(), FlexibleDate.getNowDate().getNendo());
        return new RString(String.valueOf(countedItem.next()));
    }

    /**
     * 「文書番号記号」「ヘッダー文字」「文書番号」「フッター文字」を連結した文字列を返します。（空白の場合はEmptyを返します。）
     *
     * @return RString
     */
    public RString getEdit文書番号() {

        return new RStringBuilder(div.getTxtBunshoKigo().getValue())
                .append(div.getTxtBunshoHeader().getValue())
                .append(div.getTxtBunshoNo().getValue())
                .append(div.getTxtBunshoFooter().getValue())
                .toRString();
    }

}
