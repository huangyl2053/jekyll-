/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.Shujiiikenshosakuseiirai;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ikensho.IshiKubunCode;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.dgShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 主治医意見書作成依頼のHandlerクラスです。
 */
public class ShujiiIkenshoSakuseiIraiHandler {

    private static final RString 主治医意見書作成期限設定方法_2 = new RString("2");
    private static final RString 新規 = new RString("新規");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private final ShujiiIkenshoSakuseiIraiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShujiiIkenshoSakuseiIraiDiv
     */
    public ShujiiIkenshoSakuseiIraiHandler(ShujiiIkenshoSakuseiIraiDiv div) {
        this.div = div;
    }

    /**
     * 申請者一覧を設定します。
     *
     * @param 申請者情報一覧 申請者情報一覧
     */
    public void init(List<Shujiiikenshosakuseiirai> 申請者情報一覧) {
        set申請者一覧(申請者情報一覧);
        if (主治医意見書作成期限設定方法_2.equals(BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, SubGyomuCode.DBE認定支援))) {
            div.getRadkigen().setDisabled(true);
            div.getTxtkigenymd().setDisabled(true);
        } else {
            div.getRadkigen().setDisabled(false);
            div.getTxtkigenymd().setDisabled(false);
        }
        div.getIraiprint().getTxtkigenymd().setValue(RDate.getNowDate());
        div.getTxtShujiiIkensahoSakuseiIraiDay().setValue(RDate.getNowDate());
    }

    private void set申請者一覧(List<Shujiiikenshosakuseiirai> 申請者情報一覧) {
        List<dgShinseishaIchiran_Row> 申請者一覧 = new ArrayList<>();
        for (Shujiiikenshosakuseiirai 申請者 : 申請者情報一覧) {
            dgShinseishaIchiran_Row row = new dgShinseishaIchiran_Row();
            row.setHihokenshaNo(div.getCcdHihokenshaFinder().get被保険者番号());
            if (申請者.getTemp_被保険者氏名() != null) {
                row.setHihokennshaShimei(申請者.getTemp_被保険者氏名().value());
            }
            if (申請者.getTemp_性別() != null) {
                row.setSeibetsu(Seibetsu.toValue(申請者.getTemp_性別().value()).get名称());
            }
            if (申請者.getTemp_認定申請日() != null) {
                row.getShinseiDay().setValue(new RDate(申請者.getTemp_認定申請日().toString()));
            }
            if (申請者.getTemp_申請区分() != null) {
                row.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.toValue(申請者.getTemp_申請区分().getKey()).get名称());
            }
            if (申請者.getTemp_住所() != null) {
                row.setJusho(申請者.getTemp_住所().value());
            }
            row.setShujiiIryoKikan(申請者.getTemp_主治医医療機関());
            if (申請者.getTemp_主治医() != null) {
                row.setShujii(申請者.getTemp_主治医().value());
            }
            if (申請者.getTemp_主治医意見書作成依頼日() != null) {
                row.getShujiiIkenshoSakuseiIraiDay().setValue(new RDate(申請者.getTemp_主治医意見書作成依頼日().toString()));
            }
            if (!RString.isNullOrEmpty(申請者.getTemp_主治医意見書依頼区分())) {
                row.setIraiKubun(new RString(ShujiiIkenshoIraiKubun.toValue(申請者.getTemp_主治医意見書依頼区分()).name()));
            }
            row.setHokensha(申請者.getTemp_保険者名称());
            row.setZenkaiShujiiIryoKikan(申請者.getTemp_前回主治医医療機関());
            if (申請者.getTemp_前回主治医() != null) {
                row.setShujii(申請者.getTemp_前回主治医().value());
            }
            if (申請者.getTemp_依頼書出力年月日() != null) {
                row.getIraishoShutsuryokuDay().setValue(new RDate(申請者.getTemp_依頼書出力年月日().toString()));
            }
            if (申請者.getTemp_意見書出力年月日() != null) {
                row.getIkenshoShutsuryokuDay().setValue(new RDate(申請者.getTemp_意見書出力年月日().toString()));
            }
            if (申請者.getTemp_請求書出力年月日() != null) {
                row.getSeikyushoShutsuryokuDay().setValue(new RDate(申請者.getTemp_請求書出力年月日().toString()));
            }
            row.setShujiiIryoKikanCode(申請者.getTemp_主治医医療機関コード());
            row.setShujiiCode(申請者.getTemp_主治医コード());
            row.setRirekiNo(new RString(String.valueOf(申請者.getTemp_最大履歴番号())));
            row.setPreRirekiNo(new RString(String.valueOf(申請者.getTemp_前回最大履歴番号())));
            row.setSakujoKbn(Boolean.FALSE);
            row.setShiseishoKanriNo(申請者.getTemp_申請書管理番号().value());
            row.setKoroshoIfShikibetsuCode(申請者.getTemp_厚労省IF識別コード().getKey());
            row.setIryoukikanShozaichi(申請者.getTemp_医療機関所在地());
            row.setHokensha(申請者.getTemp_保険者番号());
            row.setIryoKikanTelNo(申請者.getTemp_医療機関電話番号() == null ? RString.EMPTY : 申請者.getTemp_医療機関電話番号().value());
            if (申請者.getTemp_被保険者氏名カナ() != null) {
                row.setHihokenshaShimeiKana(申請者.getTemp_被保険者氏名カナ().value());
            }
            row.getBirthYMD().setValue(申請者.getTemp_生年月日());
            if (申請者.getTemp_郵便番号() != null) {
                row.setYubinNo(申請者.getTemp_郵便番号().value());
            }
            row.setShisetsuNyushoFlag(申請者.isTemp_施設利用フラグ());
            申請者一覧.add(row);
        }
        div.getDgShinseishaIchiran().setDataSource(申請者一覧);
    }

    /**
     * 「依頼する」ボタン押下、指定主治医値をセットします。
     */
    public void set主治医() {
        IShujiiIryokikanAndShujiiInputDiv iryokikanAndShujiiInputDiv = div.getCcdShujiiIryoKikanAndShujiiInput();
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (row.getSelected() && !削除.equals(row.getStatus())) {
                row.setShujiiIryoKikan(iryokikanAndShujiiInputDiv.getIryoKikanName());
                row.getShujiiIkenshoSakuseiIraiDay().setValue(div.getTxtShujiiIkensahoSakuseiIraiDay().getValue());
                row.setShujii(iryokikanAndShujiiInputDiv.getShujiiName());
                if (RString.isNullOrEmpty(row.getIraiKubun())) {
                    row.setStatus(新規);
                } else {
                    row.setStatus(修正);
                }
                if (iryokikanAndShujiiInputDiv.hasShiteii()) {
                    row.setIshiKbnCode(IshiKubunCode.指定医.getコード());
                    row.setShiteiiFlag(Boolean.TRUE);
                } else {
                    row.setIshiKbnCode(IshiKubunCode.主治医.getコード());
                    row.setShiteiiFlag(Boolean.FALSE);
                }
            }
        }
    }
}
