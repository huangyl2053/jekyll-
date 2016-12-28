/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2250001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.ChosaKekkaNyuryokuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.NinteishinseibiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.dgNinteiChosaData_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 認定調査データ取込（モバイル）のHandlerラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
public class NinteishinseibiHandler {

    private final NinteishinseibiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteishinseibiDiv
     */
    public NinteishinseibiHandler(NinteishinseibiDiv div) {
        this.div = div;
    }

    /**
     * 認定調査データ取込の設定します。
     *
     */
    public void initializtion() {
        div.getDgNinteiChosaData().setDataSource(new ArrayList<dgNinteiChosaData_Row>());
    }

    /**
     * 取込むの編集。
     *
     * @param row 認定調査一覧
     * @param entity ＣＳＶデータ
     * @param 特記事項List 特記事項List
     * @param 概況特記事項 概況特記事項
     */
    public void 取込むの編集(dgNinteiChosaData_Row row, ChosaKekkaNyuryokuCsvEntity entity,
            List<NinteichosahyoTokkijiko> 特記事項List, GaikyoTokki 概況特記事項) {

        row.setJyoutai(new RString("変更"));
        row.setShichosonMeisho(entity.get保険者名());
        row.setNinteiShinseiYMD(create日付文字列(entity.get認定申請年月日()));
        row.setHihokenshaNo(entity.get証記載保険者番号());
        row.setHihokenshaName(entity.get被保険者氏名());
        row.setNinteiShinseiShinseijiKubunCode(NinteiShinseiShinseijiKubunCode.to名称OrDefault(entity.get認定申請区分申請時コード(), RString.EMPTY));
        row.setNinteichosaIraiKanryoYMD(create日付文字列(entity.get認定調査依頼完了年月日()));
        row.setNinteiChosaItakusakiCode(entity.get認定調査委託先コード());
        row.setNinteiChosainCode(entity.get認定調査員コード());
        row.setNinteichosaJisshiYMD(create日付文字列(entity.get認定調査実施年月日()));
        row.setShinseishoKanriNo(entity.get申請書管理番号());
        row.setNinteichosaIraiRirekiNo(entity.get認定調査依頼履歴番号());
        row.setKoroshoIfShikibetsuCode(entity.get厚労省IF識別コード());
        if (RString.isNullOrEmpty(entity.get認定調査_認知症高齢者の日常生活自立度コード())) {
            row.setNinchishoNichijoSeikatsuJiritsudoCode(RString.EMPTY);
        } else {
            row.setNinchishoNichijoSeikatsuJiritsudoCode(
                    NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get認定調査_認知症高齢者の日常生活自立度コード()).get名称());
        }
        if (RString.isNullOrEmpty(entity.get認定調査_障害高齢者の日常生活自立度コード())) {
            row.setShogaiNichijoSeikatsuJiritsudoCode(RString.EMPTY);
        } else {
            row.setShogaiNichijoSeikatsuJiritsudoCode(
                    ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get認定調査_障害高齢者の日常生活自立度コード()).get名称());
        }
        if (RString.isNullOrEmpty(entity.get概況特記テキスト_イメージ区分コード())) {
            row.setGaikyoTokkiTextImageKubun(RString.EMPTY);
        } else {
            row.setGaikyoTokkiTextImageKubun(TokkijikoTextImageKubun.toValue(entity.get概況特記テキスト_イメージ区分コード()).get名称());
        }
        row.setJutakuKaishu(entity.get住宅改修改修箇所());
        row.setTokubetsuKyufuService(entity.get市町村特別給付サービス種類名());
        row.setZaitakuService(entity.get介護保険給付以外の在宅サービス種類名());
        if (RString.isNullOrEmpty(entity.get認定調査依頼区分コード())) {
            row.setNinteichousaIraiKubunCode(RString.EMPTY);
        } else {
            row.setNinteichousaIraiKubunCode(NinteiChousaIraiKubunCode.toValue(entity.get認定調査依頼区分コード()).get名称());
        }
        row.setNinteichosaIraiKaisu(entity.get認定調査回数());
        row.setNinteichosaJuryoYMD(create日付文字列(entity.get認定調査受領年月日()));
        row.setNinteiChosaKubunCode(entity.get認定調査区分コード());
        row.setChosaJisshiBashoCode(entity.get認定調査実施場所コード());
        row.setChosaJisshiBashoMeisho(entity.get認定調査実施場所());
        if (RString.isNullOrEmpty(entity.get認定調査_サービス区分コード())) {
            row.setServiceKubunCode(RString.EMPTY);
        } else {
            row.setServiceKubunCode(ServiceKubunCode.toValue(entity.get認定調査_サービス区分コード()).get名称());
        }
        row.setRiyoShisetsuShimei(entity.get利用施設名());
        row.setRiyoShisetsuJusho(entity.get利用施設住所());
        row.setRiyoShisetsuTelNo(entity.get利用施設電話番号());
        row.setRiyoShisetsuYubinNo(entity.get利用施設郵便番号());
        row.setTokki(entity.get特記());
        row.setTokkijikoUketsukeYMD(create日付文字列(entity.get認定調査特記事項受付年月日()));
        row.setTokkijikoJuryoYMD(create日付文字列(entity.get認定調査特記事項受領年月日()));

        //5207
        RString サービス状況連番 = createCommaSplitString(createサービス状況連番List(entity));
        row.setServiceJokyoRemban(サービス状況連番);
        if (サービス状況連番.isEmpty()) {
            row.setServiceJokyo(RString.EMPTY);
        } else {
            row.setServiceJokyo(createCommaSplitString(createサービス状況List(entity)));
        }

        //5208
        RString サービス状況フラグ連番 = createCommaSplitString(createサービス状況フラグ連番List(entity));
        row.setServiceJokyoFlagRemban(サービス状況フラグ連番);
        if (サービス状況フラグ連番.isEmpty()) {
            row.setServiceJokyoFlag(RString.EMPTY);
        } else {
            row.setServiceJokyoFlag(createCommaSplitString(createサービス状況フラグList(entity)));
        }

        //5209
        RString サービス状況記入連番 = createCommaSplitString(createサービス状況記入連番List(entity));
        row.setServiceJokyoKinyuRemban(サービス状況記入連番);
        if (サービス状況記入連番.isEmpty()) {
            row.setServiceJokyoKinyu(RString.EMPTY);
        } else {
            row.setServiceJokyoKinyu(createCommaSplitString(createサービス状況記入List(entity)));
        }

        //5210
        RString 施設利用連番 = createCommaSplitString(create施設利用連番List(entity));
        row.setShisetsuRiyoFlagRemban(施設利用連番);
        if (施設利用連番.isEmpty()) {
            row.setShisetsuRiyoFlag(RString.EMPTY);
        } else {
            row.setShisetsuRiyoFlag(createCommaSplitString(create施設利用フラグList(entity)));
        }

        //5211
        RString 調査項目連番 = createCommaSplitString(create調査項目連番List(entity));
        row.setRemban(調査項目連番);
        if (調査項目連番.isEmpty()) {
            row.setResearchItem(RString.EMPTY);
        } else {
            row.setResearchItem(createCommaSplitString(create調査項目内容List(entity)));
        }

        //特記事項
        row.setNinteichosaTokkijikoNoRemban(createCommaSplitString(create特記事項表示文字列List(特記事項List)));

        //概況特記事項
        row.setShuso(概況特記事項.get概況特記事項_主訴());
        row.setKazokuJokyo(概況特記事項.get概況特記事項_家族状況());
        row.setKyojuKankyo(概況特記事項.get概況特記事項_居住環境());
        row.setKikaiKiki(概況特記事項.get概況特記事項_機器_器械());

    }

    private RString create日付文字列(RString 年月日) {
        if (RString.isNullOrEmpty(年月日)) {
            return RString.EMPTY;
        }
        FlexibleDate date = new FlexibleDate(年月日);
        return date.wareki().eraType(EraType.KANJI_RYAKU).toDateString();
    }

    private List<RString> createサービス状況連番List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> サービス状況連番List = new ArrayList<>();
        if (entity.getサービスの状況連番01().isEmpty()) {
            return サービス状況連番List;
        }
        サービス状況連番List.add(entity.getサービスの状況連番01());
        サービス状況連番List.add(entity.getサービスの状況連番02());
        サービス状況連番List.add(entity.getサービスの状況連番03());
        サービス状況連番List.add(entity.getサービスの状況連番04());
        サービス状況連番List.add(entity.getサービスの状況連番05());
        サービス状況連番List.add(entity.getサービスの状況連番06());
        サービス状況連番List.add(entity.getサービスの状況連番07());
        サービス状況連番List.add(entity.getサービスの状況連番08());
        サービス状況連番List.add(entity.getサービスの状況連番09());
        サービス状況連番List.add(entity.getサービスの状況連番10());
        サービス状況連番List.add(entity.getサービスの状況連番11());
        サービス状況連番List.add(entity.getサービスの状況連番12());
        サービス状況連番List.add(entity.getサービスの状況連番13());
        サービス状況連番List.add(entity.getサービスの状況連番14());
        サービス状況連番List.add(entity.getサービスの状況連番15());
        サービス状況連番List.add(entity.getサービスの状況連番16());
        サービス状況連番List.add(entity.getサービスの状況連番17());
        サービス状況連番List.add(entity.getサービスの状況連番18());
        サービス状況連番List.add(entity.getサービスの状況連番19());
        サービス状況連番List.add(entity.getサービスの状況連番20());
        return サービス状況連番List;
    }

    private List<RString> createサービス状況List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> サービス状況List = new ArrayList<>();
        サービス状況List.add(entity.getサービスの状況01());
        サービス状況List.add(entity.getサービスの状況02());
        サービス状況List.add(entity.getサービスの状況03());
        サービス状況List.add(entity.getサービスの状況04());
        サービス状況List.add(entity.getサービスの状況05());
        サービス状況List.add(entity.getサービスの状況06());
        サービス状況List.add(entity.getサービスの状況07());
        サービス状況List.add(entity.getサービスの状況08());
        サービス状況List.add(entity.getサービスの状況09());
        サービス状況List.add(entity.getサービスの状況10());
        サービス状況List.add(entity.getサービスの状況11());
        サービス状況List.add(entity.getサービスの状況12());
        サービス状況List.add(entity.getサービスの状況13());
        サービス状況List.add(entity.getサービスの状況14());
        サービス状況List.add(entity.getサービスの状況15());
        サービス状況List.add(entity.getサービスの状況16());
        サービス状況List.add(entity.getサービスの状況17());
        サービス状況List.add(entity.getサービスの状況18());
        サービス状況List.add(entity.getサービスの状況19());
        サービス状況List.add(entity.getサービスの状況20());
        return サービス状況List;
    }

    private List<RString> createサービス状況フラグ連番List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> サービス状況フラグ連番List = new ArrayList<>();
        if (entity.getサービスの状況フラグ連番().isEmpty()) {
            return サービス状況フラグ連番List;
        }
        サービス状況フラグ連番List.add(entity.getサービスの状況フラグ連番());
        return サービス状況フラグ連番List;
    }

    private List<RString> createサービス状況フラグList(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> サービス状況フラグList = new ArrayList<>();
        サービス状況フラグList.add(entity.getサービスの状況フラグ());
        return サービス状況フラグList;
    }

    private List<RString> createサービス状況記入連番List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> サービス状況記入連番List = new ArrayList<>();
        if (entity.get記入項目連番01().isEmpty()) {
            return サービス状況記入連番List;
        }
        サービス状況記入連番List.add(entity.get記入項目連番01());
        サービス状況記入連番List.add(entity.get記入項目連番02());
        return サービス状況記入連番List;
    }

    private List<RString> createサービス状況記入List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> サービス状況記入List = new ArrayList<>();
        サービス状況記入List.add(entity.getサービスの状況記入01());
        サービス状況記入List.add(entity.getサービスの状況記入02());
        return サービス状況記入List;
    }

    private List<RString> create施設利用連番List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> 施設利用連番List = new ArrayList<>();
        if (entity.get施設利用連番01().isEmpty()) {
            return 施設利用連番List;
        }
        施設利用連番List.add(entity.get施設利用連番01());
        施設利用連番List.add(entity.get施設利用連番02());
        施設利用連番List.add(entity.get施設利用連番03());
        施設利用連番List.add(entity.get施設利用連番04());
        施設利用連番List.add(entity.get施設利用連番05());
        施設利用連番List.add(entity.get施設利用連番06());
        施設利用連番List.add(entity.get施設利用連番07());
        施設利用連番List.add(entity.get施設利用連番08());
        施設利用連番List.add(entity.get施設利用連番09());
        return 施設利用連番List;
    }

    private List<RString> create施設利用フラグList(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> 施設利用フラグList = new ArrayList<>();
        施設利用フラグList.add(entity.get施設利用フラグ01());
        施設利用フラグList.add(entity.get施設利用フラグ02());
        施設利用フラグList.add(entity.get施設利用フラグ03());
        施設利用フラグList.add(entity.get施設利用フラグ04());
        施設利用フラグList.add(entity.get施設利用フラグ05());
        施設利用フラグList.add(entity.get施設利用フラグ06());
        施設利用フラグList.add(entity.get施設利用フラグ07());
        施設利用フラグList.add(entity.get施設利用フラグ08());
        施設利用フラグList.add(entity.get施設利用フラグ09());
        return 施設利用フラグList;
    }

    private List<RString> create調査項目連番List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> 調査項目連番List = new ArrayList<>();
        if (entity.get調査項目連番01().isEmpty()) {
            return 調査項目連番List;
        }
        調査項目連番List.add(entity.get調査項目連番01());
        調査項目連番List.add(entity.get調査項目連番02());
        調査項目連番List.add(entity.get調査項目連番03());
        調査項目連番List.add(entity.get調査項目連番04());
        調査項目連番List.add(entity.get調査項目連番05());
        調査項目連番List.add(entity.get調査項目連番06());
        調査項目連番List.add(entity.get調査項目連番07());
        調査項目連番List.add(entity.get調査項目連番08());
        調査項目連番List.add(entity.get調査項目連番09());
        調査項目連番List.add(entity.get調査項目連番10());
        調査項目連番List.add(entity.get調査項目連番11());
        調査項目連番List.add(entity.get調査項目連番12());
        調査項目連番List.add(entity.get調査項目連番13());
        調査項目連番List.add(entity.get調査項目連番14());
        調査項目連番List.add(entity.get調査項目連番15());
        調査項目連番List.add(entity.get調査項目連番16());
        調査項目連番List.add(entity.get調査項目連番17());
        調査項目連番List.add(entity.get調査項目連番18());
        調査項目連番List.add(entity.get調査項目連番19());
        調査項目連番List.add(entity.get調査項目連番20());
        調査項目連番List.add(entity.get調査項目連番21());
        調査項目連番List.add(entity.get調査項目連番22());
        調査項目連番List.add(entity.get調査項目連番23());
        調査項目連番List.add(entity.get調査項目連番24());
        調査項目連番List.add(entity.get調査項目連番25());
        調査項目連番List.add(entity.get調査項目連番26());
        調査項目連番List.add(entity.get調査項目連番27());
        調査項目連番List.add(entity.get調査項目連番28());
        調査項目連番List.add(entity.get調査項目連番29());
        調査項目連番List.add(entity.get調査項目連番30());
        調査項目連番List.add(entity.get調査項目連番31());
        調査項目連番List.add(entity.get調査項目連番32());
        調査項目連番List.add(entity.get調査項目連番33());
        調査項目連番List.add(entity.get調査項目連番34());
        調査項目連番List.add(entity.get調査項目連番35());
        調査項目連番List.add(entity.get調査項目連番36());
        調査項目連番List.add(entity.get調査項目連番37());
        調査項目連番List.add(entity.get調査項目連番38());
        調査項目連番List.add(entity.get調査項目連番39());
        調査項目連番List.add(entity.get調査項目連番40());
        調査項目連番List.add(entity.get調査項目連番41());
        調査項目連番List.add(entity.get調査項目連番42());
        調査項目連番List.add(entity.get調査項目連番43());
        調査項目連番List.add(entity.get調査項目連番44());
        調査項目連番List.add(entity.get調査項目連番45());
        調査項目連番List.add(entity.get調査項目連番46());
        調査項目連番List.add(entity.get調査項目連番47());
        調査項目連番List.add(entity.get調査項目連番48());
        調査項目連番List.add(entity.get調査項目連番49());
        調査項目連番List.add(entity.get調査項目連番50());
        調査項目連番List.add(entity.get調査項目連番51());
        調査項目連番List.add(entity.get調査項目連番52());
        調査項目連番List.add(entity.get調査項目連番53());
        調査項目連番List.add(entity.get調査項目連番54());
        調査項目連番List.add(entity.get調査項目連番55());
        調査項目連番List.add(entity.get調査項目連番56());
        調査項目連番List.add(entity.get調査項目連番57());
        調査項目連番List.add(entity.get調査項目連番58());
        調査項目連番List.add(entity.get調査項目連番59());
        調査項目連番List.add(entity.get調査項目連番60());
        調査項目連番List.add(entity.get調査項目連番61());
        調査項目連番List.add(entity.get調査項目連番62());
        調査項目連番List.add(entity.get調査項目連番63());
        調査項目連番List.add(entity.get調査項目連番64());
        調査項目連番List.add(entity.get調査項目連番65());
        調査項目連番List.add(entity.get調査項目連番66());
        調査項目連番List.add(entity.get調査項目連番67());
        調査項目連番List.add(entity.get調査項目連番68());
        調査項目連番List.add(entity.get調査項目連番69());
        調査項目連番List.add(entity.get調査項目連番70());
        調査項目連番List.add(entity.get調査項目連番71());
        調査項目連番List.add(entity.get調査項目連番72());
        調査項目連番List.add(entity.get調査項目連番73());
        調査項目連番List.add(entity.get調査項目連番74());
        return 調査項目連番List;
    }

    private List<RString> create調査項目内容List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> 調査項目内容List = new ArrayList<>();
        調査項目内容List.add(entity.get内容01());
        調査項目内容List.add(entity.get内容02());
        調査項目内容List.add(entity.get内容03());
        調査項目内容List.add(entity.get内容04());
        調査項目内容List.add(entity.get内容05());
        調査項目内容List.add(entity.get内容06());
        調査項目内容List.add(entity.get内容07());
        調査項目内容List.add(entity.get内容08());
        調査項目内容List.add(entity.get内容09());
        調査項目内容List.add(entity.get内容10());
        調査項目内容List.add(entity.get内容11());
        調査項目内容List.add(entity.get内容12());
        調査項目内容List.add(entity.get内容13());
        調査項目内容List.add(entity.get内容14());
        調査項目内容List.add(entity.get内容15());
        調査項目内容List.add(entity.get内容16());
        調査項目内容List.add(entity.get内容17());
        調査項目内容List.add(entity.get内容18());
        調査項目内容List.add(entity.get内容19());
        調査項目内容List.add(entity.get内容20());
        調査項目内容List.add(entity.get内容21());
        調査項目内容List.add(entity.get内容22());
        調査項目内容List.add(entity.get内容23());
        調査項目内容List.add(entity.get内容24());
        調査項目内容List.add(entity.get内容25());
        調査項目内容List.add(entity.get内容26());
        調査項目内容List.add(entity.get内容27());
        調査項目内容List.add(entity.get内容28());
        調査項目内容List.add(entity.get内容29());
        調査項目内容List.add(entity.get内容30());
        調査項目内容List.add(entity.get内容31());
        調査項目内容List.add(entity.get内容32());
        調査項目内容List.add(entity.get内容33());
        調査項目内容List.add(entity.get内容34());
        調査項目内容List.add(entity.get内容35());
        調査項目内容List.add(entity.get内容36());
        調査項目内容List.add(entity.get内容37());
        調査項目内容List.add(entity.get内容38());
        調査項目内容List.add(entity.get内容39());
        調査項目内容List.add(entity.get内容40());
        調査項目内容List.add(entity.get内容41());
        調査項目内容List.add(entity.get内容42());
        調査項目内容List.add(entity.get内容43());
        調査項目内容List.add(entity.get内容44());
        調査項目内容List.add(entity.get内容45());
        調査項目内容List.add(entity.get内容46());
        調査項目内容List.add(entity.get内容47());
        調査項目内容List.add(entity.get内容48());
        調査項目内容List.add(entity.get内容49());
        調査項目内容List.add(entity.get内容50());
        調査項目内容List.add(entity.get内容51());
        調査項目内容List.add(entity.get内容52());
        調査項目内容List.add(entity.get内容53());
        調査項目内容List.add(entity.get内容54());
        調査項目内容List.add(entity.get内容55());
        調査項目内容List.add(entity.get内容56());
        調査項目内容List.add(entity.get内容57());
        調査項目内容List.add(entity.get内容58());
        調査項目内容List.add(entity.get内容59());
        調査項目内容List.add(entity.get内容60());
        調査項目内容List.add(entity.get内容61());
        調査項目内容List.add(entity.get内容62());
        調査項目内容List.add(entity.get内容63());
        調査項目内容List.add(entity.get内容64());
        調査項目内容List.add(entity.get内容65());
        調査項目内容List.add(entity.get内容66());
        調査項目内容List.add(entity.get内容67());
        調査項目内容List.add(entity.get内容68());
        調査項目内容List.add(entity.get内容69());
        調査項目内容List.add(entity.get内容70());
        調査項目内容List.add(entity.get内容71());
        調査項目内容List.add(entity.get内容72());
        調査項目内容List.add(entity.get内容73());
        調査項目内容List.add(entity.get内容74());
        return 調査項目内容List;
    }

    private RString createCommaSplitString(List<RString> valueList) {
        RStringBuilder rsb = new RStringBuilder();
        for (RString value : valueList) {
            if (rsb.length() > 0) {
                rsb.append(",");
            }
            rsb.append(value);
        }
        return rsb.toRString();
    }

    private List<RString> create特記事項表示文字列List(List<NinteichosahyoTokkijiko> 特記事項List) {
        List<RString> valueList = new ArrayList<>();
        for (NinteichosahyoTokkijiko 特記事項 : 特記事項List) {
            RString 特記事項番号 = 特記事項.get認定調査特記事項番号();
            RString 特記事項連番 = new RString(特記事項.get認定調査特記事項連番());
            RStringBuilder rsb = new RStringBuilder();
            rsb.append("{").append(特記事項番号).append(",").append(特記事項連番).append("}");
            valueList.add(rsb.toRString());
        }
        return valueList;
    }

    /**
     * 選択状態変更の判定。
     *
     * @return 取込むの判定
     */
    public boolean 選択状態変更の判定() {

        List<dgNinteiChosaData_Row> rowList = div.getDgNinteiChosaData().getSelectedItems();
        boolean flg = false;
        for (dgNinteiChosaData_Row row : rowList) {

            if (!RString.isNullOrEmpty(row.getJyoutai())) {

                flg = true;
            }
        }
        return flg;
    }

    /**
     * 認定調査票概況調査の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況調査）
     * @return 認定調査票（概況調査）ビルダー
     */
    public NinteichosahyoGaikyoChosaBuilder 認定調査票概況調査の編集(dgNinteiChosaData_Row row, NinteichosahyoGaikyoChosa entity) {

        NinteichosahyoGaikyoChosaBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set概況調査テキストイメージ区分(TokkijikoTextImageKubun.valueOf(row.
                getGaikyoTokkiTextImageKubun().toString()).getコード());
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        if (!RString.isNullOrEmpty(row.getNinteichousaIraiKubunCode())) {
            builder.set認定調査依頼区分コード(new Code(NinteiChousaIraiKubunCode.
                    valueOf(row.getNinteichousaIraiKubunCode().toString()).getコード()));
        } else {
            builder.set認定調査依頼区分コード(Code.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getNinteichosaIraiKaisu())) {
            builder.set認定調査回数(Integer.valueOf(row.getNinteichosaIraiKaisu().toString()));
        } else {
            builder.set認定調査回数(0);
        }
        builder.set認定調査実施年月日(toFlexibleDate(row.getNinteichosaJisshiYMD()));
        builder.set認定調査受領年月日(toFlexibleDate(row.getNinteichosaJuryoYMD()));
        if (!RString.isNullOrEmpty(row.getNinteiChosaKubunCode())) {
            builder.set認定調査区分コード(new Code(row.getNinteiChosaKubunCode()));
        } else {
            builder.set認定調査区分コード(Code.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getNinteiChosaItakusakiCode())) {
            builder.set認定調査委託先コード(new JigyoshaNo(row.getNinteiChosaItakusakiCode()));
        } else {
            builder.set認定調査委託先コード(JigyoshaNo.EMPTY);
        }
        builder.set認定調査員コード(row.getNinteiChosainCode());
        if (!RString.isNullOrEmpty(row.getChosaJisshiBashoCode())) {
            builder.set認定調査実施場所コード(new Code(row.getChosaJisshiBashoCode()));
        } else {
            builder.set認定調査実施場所コード(Code.EMPTY);
        }
        builder.set認定調査実施場所名称(row.getChosaJisshiBashoMeisho());
        if (!RString.isNullOrEmpty(row.getServiceKubunCode())) {
            builder.set認定調査_サービス区分コード(new Code(ServiceKubunCode.
                    valueOf(row.getServiceKubunCode().toString()).getコード()));
        } else {
            builder.set認定調査_サービス区分コード(Code.EMPTY);
        }
        builder.set利用施設名(row.getRiyoShisetsuShimei());
        if (!RString.isNullOrEmpty(row.getRiyoShisetsuJusho())) {
            builder.set利用施設住所(new AtenaJusho(row.getRiyoShisetsuJusho()));
        } else {
            builder.set利用施設住所(AtenaJusho.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getRiyoShisetsuTelNo())) {
            builder.set利用施設電話番号(new TelNo(row.getRiyoShisetsuTelNo()));
        } else {
            builder.set利用施設電話番号(TelNo.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getRiyoShisetsuYubinNo())) {
            builder.set利用施設郵便番号(new YubinNo(row.getRiyoShisetsuYubinNo()));
        } else {
            builder.set利用施設郵便番号(YubinNo.EMPTY);
        }
        builder.set特記(row.getTokki());
        builder.set認定調査特記事項受付年月日(toFlexibleDate(row.getTokkijikoUketsukeYMD()));
        builder.set認定調査特記事項受領年月日(toFlexibleDate(row.getTokkijikoJuryoYMD()));
        return builder;
    }

    /**
     * 認定調査票基本調査の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（基本調査）
     * @return 認定調査票（基本調査）ビルダー
     */
    public NinteichosahyoKihonChosaBuilder 認定調査票基本調査の編集(dgNinteiChosaData_Row row, NinteichosahyoKihonChosa entity) {

        NinteichosahyoKihonChosaBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set要介護認定調査履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set要介護認定調査履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        if (RString.isNullOrEmpty(row.getNinchishoNichijoSeikatsuJiritsudoCode())) {
            builder.set認定調査_認知症高齢者の日常生活自立度コード(Code.EMPTY);
        } else {
            builder.set認定調査_認知症高齢者の日常生活自立度コード(new Code(NinchishoNichijoSeikatsuJiritsudoCode.
                    valueOf(row.getNinchishoNichijoSeikatsuJiritsudoCode().toString()).getコード()));
        }
        if (RString.isNullOrEmpty(row.getShogaiNichijoSeikatsuJiritsudoCode())) {
            builder.set認定調査_障害高齢者の日常生活自立度コード(Code.EMPTY);
        } else {
            builder.set認定調査_障害高齢者の日常生活自立度コード(new Code(ShogaiNichijoSeikatsuJiritsudoCode.
                    valueOf(row.getShogaiNichijoSeikatsuJiritsudoCode().toString()).getコード()));
        }
        return builder;
    }

    private FlexibleDate toFlexibleDate(RString obj) {
        if (RString.isNullOrEmpty(obj)) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(new RDate(obj.toString()).toDateString());
    }
}
