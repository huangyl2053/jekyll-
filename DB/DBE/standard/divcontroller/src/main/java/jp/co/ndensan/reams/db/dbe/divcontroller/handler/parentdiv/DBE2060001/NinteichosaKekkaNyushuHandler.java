/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2060001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.ChosaInputCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.NinteichosaKekkaNyushuDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairailist.NinteichosaIraiListManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・認定調査結果入手のHandlerクラスです。
 *
 * @reamsid_L DBE-0310-010 dingyi
 */
public class NinteichosaKekkaNyushuHandler {

    private final NinteichosaKekkaNyushuDiv div;
    private static final RString 調査入手モード = new RString("調査入手モード");
    private static final RString 使用する = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 完了処理・認定調査結果入手Div
     */
    public NinteichosaKekkaNyushuHandler(NinteichosaKekkaNyushuDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・認定調査結果入手に初期化を設定します。
     */
    public void onLoad() {
        div.getCcdTaskList().initialize(調査入手モード);
        RString モバイル調査使用有無 = DbBusinessConfig.get(ConfigNameDBE.モバイル調査使用有無, RDate.getNowDate());
        if (使用する.equals(モバイル調査使用有無)) {
            div.getBtncyosakekkainput().setDisabled(false);
        } else {
            div.getBtncyosakekkainput().setDisabled(true);
        }
    }

    /**
     * 「モバイルデータを取込む」ボタンを押下する場合、ファイルを読み込み処理を実行します。
     *
     * @param csvEntityList ＣＳＶからデータリスト
     */
    public void onClick_btnCyosakekkaInput(List<ChosaInputCsvEntity> csvEntityList) {
        saveCsvDataInput(csvEntityList);
    }

    /**
     * 「調査票入手を完了する」ボタンを押下する場合、ＤＢに更新する処理を実行します。
     *
     * @param 要介護認定完了情報Model 要介護認定完了情報Model
     */
    public void onClick_btnChousaResultKanryo(Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> 要介護認定完了情報Model) {
        List<dgNinteiTaskList_Row> 選択されたデータ = div.getCcdTaskList().getCheckbox();
        for (dgNinteiTaskList_Row row : 選択されたデータ) {
            NinteiKanryoJohoIdentifier 要介護認定完了情報の識別子 = new NinteiKanryoJohoIdentifier(
                    new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            要介護認定完了情報Model.get(要介護認定完了情報の識別子);
            NinteichosaIraiListManager.createInstance().save要介護認定完了情報(要介護認定完了情報Model.get(要介護認定完了情報の識別子).
                    createBuilderForEdit().set認定調査完了年月日(FlexibleDate.getNowDate()).build().toEntity());
        }
    }

    private void saveCsvDataInput(List<ChosaInputCsvEntity> csvEntityList) {
        for (ChosaInputCsvEntity csvEntity : csvEntityList) {
            NinteichosahyoGaikyoChosa 認定調査票概況調査 = set認定調査票概況調査(csvEntity);
            GaikyoTokki 認定調査票概況特記 = set認定調査票概況特記(csvEntity);
            NinteichosahyoTokkijiko 認定調査票特記情報 = set認定調査票特記情報(csvEntity);
            NinteichosahyoKihonChosa 認定調査票基本調査 = set認定調査票基本調査(csvEntity);
            NinteichosahyoChosaItem 認定調査票基本調査調査項目 = set認定調査票基本調査調査項目(csvEntity);
            NinteichosahyoServiceJokyo 認定調査票概況調査サービスの状況 = set認定調査票概況調査サービスの状況(csvEntity);
            NinteichosahyoServiceJokyoFlag 認定調査票概況調査サービスの状況フラグ = set認定調査票概況調査サービスの状況フラグ(csvEntity);
            NinteichosahyoKinyuItem 認定調査票概況調査記入項目 = set認定調査票概況調査記入項目(csvEntity);
            NinteichosahyoShisetsuRiyo 認定調査票概況調査施設利用 = set認定調査票概況調査施設利用(csvEntity);
            NinteichosaIraiListManager.createInstance().saveCsvDataInput(
                    認定調査票概況調査,
                    認定調査票概況特記,
                    認定調査票特記情報,
                    認定調査票基本調査,
                    認定調査票基本調査調査項目,
                    認定調査票概況調査サービスの状況,
                    認定調査票概況調査サービスの状況フラグ,
                    認定調査票概況調査記入項目,
                    認定調査票概況調査施設利用);
        }
    }

    private NinteichosahyoGaikyoChosa set認定調査票概況調査(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoGaikyoChosa 認定調査票概況調査 = new NinteichosahyoGaikyoChosa(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                csvEntity.getGaikyoChosaTextImageKubun());
        return 認定調査票概況調査.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                set認定調査依頼区分コード(new Code(csvEntity.getNinteichousaIraiKubunCode())).
                set認定調査回数(Integer.parseInt(csvEntity.getNinteichosaIraiKaisu().toString())).
                set認定調査実施年月日(dateFormart(csvEntity.getNinteichosaJisshiYMD())).
                set認定調査受領年月日(dateFormart(csvEntity.getNinteichosaJuryoYMD())).
                set認定調査区分コード(new Code(csvEntity.getNinteiChosaKubunCode())).
                set認定調査委託先コード(new JigyoshaNo(csvEntity.getNinteiChosaItakusakiCode())).
                set認定調査員コード(csvEntity.getNinteiChosainCode()).
                set認定調査実施場所コード(Code.EMPTY).
                set認定調査実施場所名称(csvEntity.getChosaJisshiBashoMeisho()).
                set認定調査_サービス区分コード(new Code(csvEntity.getServiceKubunCode())).
                set利用施設名(csvEntity.getRiyoShisetsuShimei()).
                set利用施設住所(new AtenaJusho(csvEntity.getRiyoShisetsuJusho())).
                set利用施設電話番号(new TelNo(csvEntity.getRiyoShisetsuTelNo())).
                set利用施設郵便番号(new YubinNo(csvEntity.getRiyoShisetsuYubinNo())).
                set特記(csvEntity.getTokki()).
                set認定調査特記事項受付年月日(dateFormart(csvEntity.getTokkijikoUketsukeYMD())).
                set認定調査特記事項受領年月日(dateFormart(csvEntity.getTokkijikoJuryoYMD())).
                build();
    }

    private GaikyoTokki set認定調査票概況特記(ChosaInputCsvEntity csvEntity) {
        GaikyoTokki 認定調査票概況特記 = new GaikyoTokki(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                csvEntity.getGaikyoChosaTextImageKubun());
        return 認定調査票概況特記.createBuilderForEdit().
                set住宅改修(csvEntity.getJutakuKaishu()).
                set市町村特別給付サービス種類名(csvEntity.getTokubetsuKyufuService()).
                set介護保険給付以外の在宅サービス種類名(csvEntity.getZaitakuService()).
                set概況特記事項_主訴(csvEntity.getShuso()).
                set概況特記事項_家族状況(csvEntity.getKazokuJokyo()).
                set概況特記事項_居住環境(csvEntity.getKyojuKankyo()).
                set概況特記事項_機器_器械(csvEntity.getKikaiKiki()).
                build();
    }

    private NinteichosahyoTokkijiko set認定調査票特記情報(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoTokkijiko 認定調査票特記情報 = new NinteichosahyoTokkijiko(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                csvEntity.getNinteichosaTokkijikoNo(),
                Integer.parseInt(csvEntity.getNinteichosaTokkijikoRemban().toString()),
                csvEntity.getGaikyoChosaTextImageKubun(),
                new Code(csvEntity.getGenponMaskKubun()));
        return 認定調査票特記情報.createBuilderForEdit().
                set特記事項(使用する).
                build();
    }

    private NinteichosahyoKihonChosa set認定調査票基本調査(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoKihonChosa 認定調査票基本調査 = new NinteichosahyoKihonChosa(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()));
        return 認定調査票基本調査.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                set認定調査_認知症高齢者の日常生活自立度コード(new Code(csvEntity.getNinchishoNichijoSeikatsuJiritsudoCode())).
                set認定調査_障害高齢者の日常生活自立度コード(new Code(csvEntity.getShogaiNichijoSeikatsuJiritsudoCode())).
                build();
    }

    private NinteichosahyoChosaItem set認定調査票基本調査調査項目(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoChosaItem 認定調査票基本調査調査項目 = new NinteichosahyoChosaItem(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                Integer.parseInt(csvEntity.getResearchItemRemban().toString()));
        return 認定調査票基本調査調査項目.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                set調査項目(csvEntity.getResearchItem()).
                build();
    }

    private NinteichosahyoServiceJokyo set認定調査票概況調査サービスの状況(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoServiceJokyo 認定調査票概況調査サービスの状況 = new NinteichosahyoServiceJokyo(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                Integer.parseInt(csvEntity.getServiceJokyoRemban().toString()));
        return 認定調査票概況調査サービスの状況.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                setサービスの状況(Integer.parseInt(csvEntity.getServiceJokyo().toString())).
                build();
    }

    private NinteichosahyoServiceJokyoFlag set認定調査票概況調査サービスの状況フラグ(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoServiceJokyoFlag 認定調査票概況調査サービスの状況フラグ = new NinteichosahyoServiceJokyoFlag(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                Integer.parseInt(csvEntity.getServiceJokyoFlagRemban().toString()));
        return 認定調査票概況調査サービスの状況フラグ.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                setサービスの状況フラグ(Boolean.getBoolean(csvEntity.getServiceJokyoFlag().toString())).
                build();
    }

    private NinteichosahyoKinyuItem set認定調査票概況調査記入項目(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoKinyuItem 認定調査票概況調査サービスの状況フラグ = new NinteichosahyoKinyuItem(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                Integer.parseInt(csvEntity.getServiceJokyoKinyuRemban().toString()));
        return 認定調査票概況調査サービスの状況フラグ.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                setサービスの状況記入(csvEntity.getServiceJokyoKinyu()).
                build();
    }

    private NinteichosahyoShisetsuRiyo set認定調査票概況調査施設利用(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoShisetsuRiyo 認定調査票概況調査施設利用 = new NinteichosahyoShisetsuRiyo(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                Integer.parseInt(csvEntity.getShisetsuRiyoFlagRemban().toString()));
        return 認定調査票概況調査施設利用.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                set施設利用フラグ(Boolean.getBoolean(csvEntity.getShisetsuRiyoFlag().toString())).
                build();
    }

    private FlexibleDate dateFormart(RString 年月日) {
        return RString.isNullOrEmpty(年月日) ? FlexibleDate.EMPTY : new FlexibleDate(new RDate(年月日.toString()).toDateString());
    }

}
