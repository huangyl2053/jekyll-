/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0081011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.saisinsaketeijyohou.TaishoshaKensakuBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0081011.TaishoshaKensakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0081011.dgKetteiHokenshaDetail_Row;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBCMN11004_高額介護サービス費照会のHandlerです。
 *
 * @reamsid_L DBC-3040-010 zhangzhiming
 */
public class TaishoshaKensakuHandler {

    private final TaishoshaKensakuDiv div;
    private static final RString 広域 = new RString("111");
    private static final RString 市町村識別ID_00 = new RString("00");
    private static final RString 市町村識別ID_01 = new RString("01");
    private static final RString 市町村識別ID_99 = new RString("99");
    private static final RString キー = new RString("000000");
    private static final RString 保険者区分_1 = new RString("1");
    private static final RString 保険者区分_3 = new RString("3");
    private static final RString 保険者区分_2 = new RString("2");
    private static final RString 保険者区分_4 = new RString("4");
    private static final RString 保険者負担額 = new RString("txtHokehunta");
    private static final RString 公費負担額 = new RString("txtKouhiFutangaku");
    private static final RString 公費保険者番号 = new RString("txtKouhiHokensyaNo");

    /**
     * 再審査申立決定情報照会のHandlerです。
     *
     * @param div TaishoshaKensakuDiv
     */
    public TaishoshaKensakuHandler(TaishoshaKensakuDiv div) {
        this.div = div;
    }

    /**
     * 再審査申立決定情報照会を初期化です。
     *
     * @param 市町村情報 市町村情報
     * @param 市町村識別ID 市町村識別ID
     * @param 構成市町村 構成市町村
     */
    public void onLoad(ShichosonSecurityJoho 市町村情報, List<AuthorityItem> 市町村識別ID, List<KoikiZenShichosonJoho> 構成市町村) {
        if (広域.equals(市町村情報.get導入形態コード().value())) {
            div.getDDLSityouson().setDisplayNone(false);
            div.getDDLSityouson().setVisible(true);
        }
        List<KeyValueDataSource> list = new ArrayList<>();
        if (!市町村識別ID.isEmpty() && 市町村識別ID_00.equals(市町村識別ID.get(0).getItemId())) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(キー);
            keyValue.setValue(new RString("000000 全市町村"));
            list.add(keyValue);
            for (KoikiZenShichosonJoho koikiZen : 構成市町村) {
                if (!new RString("0").equals(koikiZen.get所得引出方法())) {
                    KeyValueDataSource key = new KeyValueDataSource();
                    RStringBuilder builder = new RStringBuilder();
                    builder.append(koikiZen.get市町村コード().value());
                    builder.append(RString.HALF_SPACE);
                    builder.append(koikiZen.get市町村名称());
                    key.setKey(koikiZen.get市町村コード().value());
                    key.setValue(builder.toRString());
                    list.add(key);
                }
            }
        }
        if (!市町村識別ID.isEmpty() && (市町村識別ID_01.equals(市町村識別ID.get(0).getItemId())
                || 市町村識別ID_99.equals(市町村識別ID.get(0).getItemId()))) {
            KeyValueDataSource key = new KeyValueDataSource();
            RStringBuilder builder = new RStringBuilder();
            builder.append(市町村情報.get市町村情報().get市町村コード().value());
            builder.append(RString.HALF_SPACE);
            builder.append(市町村情報.get市町村情報().get市町村名称());
            key.setKey(市町村情報.get市町村情報().get市町村コード().value());
            key.setValue(builder.toRString());
            list.add(key);
        }
        div.getDDLSityouson().setDataSource(list);
        if (!div.getDDLSityouson().getDataSource().isEmpty() && キー.equals(div.getDDLSityouson().getDataSource().get(0).getKey())) {
            div.getBtnKouhiFutansya().setDisabled(true);
            div.getBtnSougouKouhiFutansya().setDisabled(true);
        }
        div.getDDLRireki().setDataSource(new ArrayList<KeyValueDataSource>());
        div.getDgKetteiHokenshaDetail().setDataSource(new ArrayList<dgKetteiHokenshaDetail_Row>());
    }

    /**
     * 再審査申立決定情報照会を取得です。
     *
     * @param 保険者Business 保険者情報
     * @param 総合保険者Business 総合保険者情報
     * @param 公費負担者Business 公費負担者情報
     * @param 総合公費負担者Business 総合公費負担者情報
     * @param 履歴番号Business 履歴番号情報
     * @return List<TaishoshaKensakuBusiness> 再審査決定情報
     */
    public List<TaishoshaKensakuBusiness> onClick_btnSearch(List<TaishoshaKensakuBusiness> 保険者Business,
            List<TaishoshaKensakuBusiness> 総合保険者Business, List<TaishoshaKensakuBusiness> 公費負担者Business,
            List<TaishoshaKensakuBusiness> 総合公費負担者Business, List<TaishoshaKensakuBusiness> 履歴番号Business) {
        List<TaishoshaKensakuBusiness> 再審査決定情報 = new ArrayList<>();
        if (!保険者Business.isEmpty()) {
            get再審査決定情報(保険者Business, 保険者区分_1, 履歴番号Business);
            再審査決定情報 = 保険者Business;
        }
        if (保険者Business.isEmpty() && !総合保険者Business.isEmpty()) {
            get再審査決定情報(総合保険者Business, 保険者区分_3, 履歴番号Business);
            再審査決定情報 = 総合保険者Business;
        }
        if (保険者Business.isEmpty() && 総合保険者Business.isEmpty() && !公費負担者Business.isEmpty()) {
            get再審査決定情報(公費負担者Business, 保険者区分_2, 履歴番号Business);
            再審査決定情報 = 公費負担者Business;
        }
        if (保険者Business.isEmpty() && 総合保険者Business.isEmpty() && 公費負担者Business.isEmpty() && !総合公費負担者Business.isEmpty()) {
            get再審査決定情報(総合公費負担者Business, 保険者区分_4, 履歴番号Business);
            再審査決定情報 = 総合公費負担者Business;
        }
        return 再審査決定情報;
    }

    /**
     * 保険者情報を取得です。
     *
     * @param 再審査決定情報 再審査決定情報
     * @param 保険者区分 保険者区分
     * @param 履歴番号Business 履歴番号情報
     */
    public void set再審査決定情報(List<TaishoshaKensakuBusiness> 再審査決定情報, RString 保険者区分, List<TaishoshaKensakuBusiness> 履歴番号Business) {
        if (!再審査決定情報.isEmpty()) {
            get再審査決定情報(再審査決定情報, 保険者区分, 履歴番号Business);
        } else {
            get再審査(保険者区分);
        }
    }

    private void get再審査(RString 保険者区分) {
        div.getDDLRireki().setDataSource(new ArrayList<KeyValueDataSource>());
        div.getDgKetteiHokenshaDetail().setDataSource(new ArrayList<dgKetteiHokenshaDetail_Row>());
        div.getKetteiHokensha().setKubunn(保険者区分);
        if (保険者区分_2.equals(保険者区分) || 保険者区分_4.equals(保険者区分)) {
            div.getDgKetteiHokenshaDetail().getGridSetting().getColumn(保険者負担額).setVisible(false);
            div.getDgKetteiHokenshaDetail().getGridSetting().getColumn(公費負担額).setVisible(true);
            div.getDgKetteiHokenshaDetail().getGridSetting().getColumn(公費保険者番号).setVisible(true);
            div.getLblSeikyuFutangaku().setText(new RString("請求公費負担額"));
            div.getLblKeteiFutangaku().setText(new RString("決定公費負担額"));
            div.getLblTyouseiFutangaku().setText(new RString("調整公費負担額"));
        } else {
            div.getDgKetteiHokenshaDetail().getGridSetting().getColumn(保険者負担額).setVisible(true);
            div.getDgKetteiHokenshaDetail().getGridSetting().getColumn(公費負担額).setVisible(false);
            div.getDgKetteiHokenshaDetail().getGridSetting().getColumn(公費保険者番号).setVisible(false);
        }
        if (保険者区分_3.equals(保険者区分) || 保険者区分_4.equals(保険者区分)) {
            div.getLblKetteihokenshaKaigokyuhuhi().setText(new RString("介護予防・日常生活支援総合事業費"));
            div.getTxtKougakuSeikyuKensu().setVisible(false);
            div.getTxtKougakuKeiteKensu().setVisible(false);
            div.getTxtKougakuYouseiKensu().setVisible(false);
            div.getTxtkougakuSeikyuTani().setVisible(false);
            div.getTxtKougakuKeteiTani().setVisible(false);
            div.getTxtKougakuTyoseiTani().setVisible(false);
            div.getTxtKougakuSeikyuFutangaku().setVisible(false);
            div.getTxtKougakuKeteiFutangaku().setVisible(false);
            div.getTxtKougakuTyoseiFutangaku().setVisible(false);
        } else {
            div.getLblKetteihokenshaKaigokyuhuhi().setText(new RString("介護給付費"));
            div.getTxtKougakuSeikyuKensu().setVisible(true);
            div.getTxtKougakuKeiteKensu().setVisible(true);
            div.getTxtKougakuYouseiKensu().setVisible(true);
            div.getTxtkougakuSeikyuTani().setVisible(true);
            div.getTxtKougakuKeteiTani().setVisible(true);
            div.getTxtKougakuTyoseiTani().setVisible(true);
            div.getTxtKougakuSeikyuFutangaku().setVisible(true);
            div.getTxtKougakuKeteiFutangaku().setVisible(true);
            div.getTxtKougakuTyoseiFutangaku().setVisible(true);
        }
        div.getTxtKetteiHokenshaSakuseiYMD().clearValue();
        div.getTxtSinsaiinkai().clearValue();
        div.getDDLRireki().setDataSource(new ArrayList<KeyValueDataSource>());
        div.getTxtKaigoSeikyuKensu().clearValue();
        div.getTxtKaigoKeiteKensu().clearValue();
        div.getTxtKaigoYouseiKensu().clearValue();
        div.getTxtKaigoSeikyuTani().clearValue();
        div.getTxtKaigoKeteiTani().clearValue();
        div.getTxtKaigoTyoseiTani().clearValue();
        div.getTxtKaigoSeikyuFutangaku().clearValue();
        div.getTxtKaigoKeteiFutangaku().clearValue();
        div.getTxtKaigoTyoseiFutangaku().clearValue();
        div.getTxtKougakuSeikyuKensu().clearValue();
        div.getTxtKougakuKeiteKensu().clearValue();
        div.getTxtKougakuYouseiKensu().clearValue();
        div.getTxtkougakuSeikyuTani().clearValue();
        div.getTxtKougakuKeteiTani().clearValue();
        div.getTxtKougakuTyoseiTani().clearValue();
        div.getTxtKougakuSeikyuFutangaku().clearValue();
        div.getTxtKougakuKeteiFutangaku().clearValue();
        div.getTxtKougakuTyoseiFutangaku().clearValue();
    }

    private void get再審査決定情報(List<TaishoshaKensakuBusiness> 再審査決定情報, RString 保険者区分, List<TaishoshaKensakuBusiness> 履歴番号Business) {
        List<KeyValueDataSource> list = new ArrayList<>();
        if (!履歴番号Business.isEmpty()) {
            for (TaishoshaKensakuBusiness 履歴番号 : 履歴番号Business) {
                if (保険者区分.equals(履歴番号.get保険者区分())) {
                    KeyValueDataSource key = new KeyValueDataSource();
                    key.setKey(new RString(履歴番号.get履歴番号()));
                    key.setValue(new RString(履歴番号.get履歴番号()));
                    list.add(key);
                }
            }
        }
        div.getDDLRireki().setDataSource(list);
        if (!list.isEmpty()) {
            div.getDDLRireki().setSelectedKey(list.get(0).getKey());
        }
        List<dgKetteiHokenshaDetail_Row> rowList = new ArrayList<>();
        div.getKetteiHokensha().setKubunn(保険者区分);
        if (!RString.isNullOrEmpty(再審査決定情報.get(0).get作成年月日())) {
            div.getTxtKetteiHokenshaSakuseiYMD().setValue(new RDate(再審査決定情報.get(0).get作成年月日().toString()));
        }
        if (保険者区分_2.equals(保険者区分) || 保険者区分_4.equals(保険者区分)) {
            div.getDgKetteiHokenshaDetail().getGridSetting().getColumn(保険者負担額).setVisible(false);
            div.getDgKetteiHokenshaDetail().getGridSetting().getColumn(公費負担額).setVisible(true);
            div.getDgKetteiHokenshaDetail().getGridSetting().getColumn(公費保険者番号).setVisible(true);
            div.getLblSeikyuFutangaku().setText(new RString("請求公費負担額"));
            div.getLblKeteiFutangaku().setText(new RString("決定公費負担額"));
            div.getLblTyouseiFutangaku().setText(new RString("調整公費負担額"));
        } else {
            div.getDgKetteiHokenshaDetail().getGridSetting().getColumn(保険者負担額).setVisible(true);
            div.getDgKetteiHokenshaDetail().getGridSetting().getColumn(公費負担額).setVisible(false);
            div.getDgKetteiHokenshaDetail().getGridSetting().getColumn(公費保険者番号).setVisible(false);
        }
        if (保険者区分_3.equals(保険者区分) || 保険者区分_4.equals(保険者区分)) {
            div.getLblKetteihokenshaKaigokyuhuhi().setText(new RString("介護予防・日常生活支援総合事業費"));
            div.getTxtKougakuSeikyuKensu().setVisible(false);
            div.getTxtKougakuKeiteKensu().setVisible(false);
            div.getTxtKougakuYouseiKensu().setVisible(false);
            div.getTxtkougakuSeikyuTani().setVisible(false);
            div.getTxtKougakuKeteiTani().setVisible(false);
            div.getTxtKougakuTyoseiTani().setVisible(false);
            div.getTxtKougakuSeikyuFutangaku().setVisible(false);
            div.getTxtKougakuKeteiFutangaku().setVisible(false);
            div.getTxtKougakuTyoseiFutangaku().setVisible(false);
        } else {
            div.getLblKetteihokenshaKaigokyuhuhi().setText(new RString("介護給付費"));
            div.getTxtKougakuSeikyuKensu().setVisible(true);
            div.getTxtKougakuKeiteKensu().setVisible(true);
            div.getTxtKougakuYouseiKensu().setVisible(true);
            div.getTxtkougakuSeikyuTani().setVisible(true);
            div.getTxtKougakuKeteiTani().setVisible(true);
            div.getTxtKougakuTyoseiTani().setVisible(true);
            div.getTxtKougakuSeikyuFutangaku().setVisible(true);
            div.getTxtKougakuKeteiFutangaku().setVisible(true);
            div.getTxtKougakuTyoseiFutangaku().setVisible(true);
        }
        div.getTxtSinsaiinkai().setValue(再審査決定情報.get(0).get審査委員会名());
        div.getTxtKaigoSeikyuKensu().setValue(new Decimal(再審査決定情報.get(0).get介護請求件数()));
        div.getTxtKaigoKeiteKensu().setValue(new Decimal(再審査決定情報.get(0).get介護決定件数()));
        div.getTxtKaigoYouseiKensu().setValue(new Decimal(再審査決定情報.get(0).get介護調整件数()));
        div.getTxtKaigoSeikyuTani().setValue(再審査決定情報.get(0).get介護請求単位());
        div.getTxtKaigoKeteiTani().setValue(再審査決定情報.get(0).get介護決定単位());
        div.getTxtKaigoTyoseiTani().setValue(再審査決定情報.get(0).get介護調整単位());
        div.getTxtKaigoSeikyuFutangaku().setValue(再審査決定情報.get(0).get介護請求保険者負担額());
        div.getTxtKaigoKeteiFutangaku().setValue(再審査決定情報.get(0).get介護決定保険者負担額());
        div.getTxtKaigoTyoseiFutangaku().setValue(再審査決定情報.get(0).get介護調整保険者負担額());
        div.getTxtKougakuSeikyuKensu().setValue(new Decimal(再審査決定情報.get(0).get高額請求件数()));
        div.getTxtKougakuKeiteKensu().setValue(new Decimal(再審査決定情報.get(0).get高額決定件数()));
        div.getTxtKougakuYouseiKensu().setValue(new Decimal(再審査決定情報.get(0).get高額調整件数()));
        div.getTxtkougakuSeikyuTani().setValue(再審査決定情報.get(0).get高額請求単位());
        div.getTxtKougakuKeteiTani().setValue(再審査決定情報.get(0).get高額決定単位());
        div.getTxtKougakuTyoseiTani().setValue(再審査決定情報.get(0).get高額調整単位());
        div.getTxtKougakuSeikyuFutangaku().setValue(再審査決定情報.get(0).get高額請求保険者負担額());
        div.getTxtKougakuKeteiFutangaku().setValue(再審査決定情報.get(0).get高額決定保険者負担額());
        div.getTxtKougakuTyoseiFutangaku().setValue(再審査決定情報.get(0).get高額調整保険者負担額());
        for (TaishoshaKensakuBusiness 一覧明細 : 再審査決定情報) {
            dgKetteiHokenshaDetail_Row row = new dgKetteiHokenshaDetail_Row();
            row.setTxtHokenshaJigyoshaNo(一覧明細.get事業所番号());
            row.setTxtHokenshaJigyoshaName(一覧明細.get事業所名());
            row.setTxtHokenshaHihoNo(一覧明細.get被保険者番号());
            row.setTxtHokenshaHihoName(一覧明細.get宛名名称());
            row.setTxtHokenshaMoshitateRiyu(一覧明細.get申立事由コード());
            row.setTxtMousitateTaisyou(一覧明細.getコード名称());
            row.setTxtMote(一覧明細.get再審査申立事由());
            row.setTxtHokenshaServiceTeikyoYM(一覧明細.getサービス提供年月());
            row.setTxtHokenshaServiceType(一覧明細.getサービス種類コード());
            row.setTxtHokenshaStyle(一覧明細.getサービス種類名());
            row.setTxtSasia(一覧明細.get再審査結果コード());
            row.setTxtTose(一覧明細.get当初請求単位数());
            row.setTxtGensinTani(一覧明細.get原審単位数());
            row.setTxtMousitateTani(一覧明細.get申立単位数());
            row.setTxtKeteiTani(一覧明細.get決定単位数());
            row.setTxtTyoseiTani(一覧明細.get調整単位数());
            row.setTxtHokehunta(一覧明細.get保険者負担額());
            row.setTxtKouhiFutangaku(一覧明細.get保険者負担額());
            row.setTxtKouhiHokensyaNo(一覧明細.get公費受給者番号());
            row.setTxtHokenshaShokisaiHokenshaNo(一覧明細.get証記載保険者番号());
            rowList.add(row);
            アクセスログ(一覧明細.get被保険者番号());
        }
        div.getDgKetteiHokenshaDetail().setDataSource(rowList);
    }

    /**
     * 市町村指定DDL表示制御を変更です。
     *
     */
    public void onChange_Shichousonn() {
        if (キー.equals(div.getDDLSityouson().getSelectedKey())) {
            div.getBtnKouhiFutansya().setVisible(true);
            div.getBtnSougouKouhiFutansya().setVisible(true);
        } else {
            div.getBtnKouhiFutansya().setVisible(false);
            div.getBtnSougouKouhiFutansya().setVisible(false);
        }
    }

    /**
     * アクセスログを出力です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void アクセスログ(RString 被保険者番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(被保険者番号));
    }

    private PersonalData toPersonalData(RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
