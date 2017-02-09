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
import jp.co.ndensan.reams.ur.urz.definition.core.bunshono.UrUDE005NoEditPattern;
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
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 文書番号入力Divの操作を行うクラスです。
 */
public class BunshoBangoInputHandler {

    private final BunshoBangoInputDiv div;
    private final static RString regexExp = new RString("_[0-9]{6}");
    private final static int 帳票末尾確認用文字数 = 7;

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
        div.setHdnChihoKokyoDantaiCode(RString.EMPTY);

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
            div.getTxtBunshoNo().setMaxLength(bunshoNo.get文書番号有効文字数());
        } else {
            div.setMode_DisplayType(BunshoBangoInputDiv.DisplayType.JidoSaiban);
            if (帳票ID.value().length() > 帳票末尾確認用文字数) {
                RString 作業用地方公共団体コード = 帳票ID.value().substring(帳票ID.value().length() - 帳票末尾確認用文字数);
                if (RStringUtil.matchesRegex(作業用地方公共団体コード, regexExp)) {
                    div.setHdnChihoKokyoDantaiCode(作業用地方公共団体コード.substring(1));
                }
            }
        }
        div.getTxtBunshoNo().setPaddingZero(bunshoNo.get文書番号編集区分() == UrUDE005NoEditPattern.前ゼロ編集);
        div.setHdnPadSpaceFlag(new RString(bunshoNo.get文書番号編集区分() == UrUDE005NoEditPattern.前スペース編集));

        if (bunshoNo.is文書番号出力()) {
            if (bunshoNo.is文書番号記号付与()) {
                div.getTxtBunshoKigo().setValue(bunshoNo.getEdit文書番号記号());
            }
            if (bunshoNo.isヘッダー付与()) {
                div.getTxtBunshoHeader().setValue(bunshoNo.getEditヘッダー文字());
            }
            if (bunshoNo.isフッター付与()) {
                div.getTxtBunshoFooter().setValue(bunshoNo.getEditフッター文字());
            }
            if (BunshoNoHatsubanHoho.toValue(bunshoNo.get文書番号発番方法()) == BunshoNoHatsubanHoho.固定) {
                div.getTxtBunshoNo().setValue(bunshoNo.get文書番号固定文字());
            }
        } else {
            div.setDisabled(true);
        }
    }

    /**
     * 採番APIを使用して文書番号を取得します。
     *
     * @return RString
     */
    public RString get自動採番文書番号() {
        SubGyomuCode サブ業務コード = ControlDataHolder.getSubGyomuCD();
        CountedItem countedItem;
        if (div.getHdnChihoKokyoDantaiCode() != null && !div.getHdnChihoKokyoDantaiCode().isEmpty()) {
            countedItem = Saiban.get(サブ業務コード, SaibanHanyokeyName.文書番号.get名称().concat(div.getHdnChihoKokyoDantaiCode()), FlexibleDate.getNowDate().getNendo());
        } else {
            countedItem = Saiban.get(サブ業務コード, SaibanHanyokeyName.文書番号.get名称(), FlexibleDate.getNowDate().getNendo());
        }
        return new RString(String.valueOf(countedItem.next()));
    }

    /**
     * 「文書番号記号」「ヘッダー文字」「文書番号」「フッター文字」を連結した文字列を返します。<br/>
     * 文書番号が空白だった場合は、最大桁数分の空白文字を文書番号として返します。
     *
     * @return RString
     */
    public RString getEdit文書番号() {
        RString bunshoNo = div.getTxtBunshoNo().getValue();
        boolean is前スペース編集 = Boolean.parseBoolean(div.getHdnPadSpaceFlag().toString());
        bunshoNo = is前スペース編集
                ? bunshoNo.padLeft(div.getTxtBunshoNo().getMaxLength())
                : bunshoNo;
        return new RStringBuilder(div.getTxtBunshoKigo().getValue())
                .append(div.getTxtBunshoHeader().getValue())
                .append(bunshoNo.isEmpty()
                        ? RString.EMPTY.padLeft(div.getTxtBunshoNo().getMaxLength())
                        : bunshoNo)
                .append(div.getTxtBunshoFooter().getValue())
                .toRString();
    }

}
