/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.euc.dbe010003;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.Renban;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout.IkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010003_IkenshoJoho99AEucEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.Anteisei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.GankaJusihnUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku18;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku19;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IsFujinkaJushinUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IsGekaJushinUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IsHifukaJushinUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IsHinyokikaJushinUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IsIkenshoDoiUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IsNaikajJshinUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IsNoshinkeigekaJushinUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IsSeikeigekaJushinUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IsSeishinkaJushinUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IshiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.JibiinkokajyushinUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.RehabiritationkaJushinUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ShikaJushinUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.SonotaJushinkaUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.TakaJushinUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShienShinseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 申請者意見書情報99ACSVエンティティ編集クラスです。
 *
 * @author N3212 竹内 和紀
 */
public final class IkenshoJoho99AEucEntityEditor {

    private static final RString 改行 = new RString("<br/>");
    private static final RString 下矢印 = new RString("↓");

    private IkenshoJoho99AEucEntityEditor() {
    }

    /**
     * DBE010003_IkenshoJoho99AEucEntityを編集して返します。
     *
     * @param entity IkenshoJohoEntity
     * @param 記入項目List DbT5303ShujiiIkenshoKinyuItemEntityのリスト
     * @param 意見項目List DbT5304ShujiiIkenshoIkenItemEntityのリスト
     * @return DBE010003_IkenshoJoho99AEucEntity
     */
    public static DBE010003_IkenshoJoho99AEucEntity edit(IkenshoJohoEntity entity,
            List<DbT5303ShujiiIkenshoKinyuItemEntity> 記入項目List,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 意見項目List) {
        DBE010003_IkenshoJoho99AEucEntity eucEntity = new DBE010003_IkenshoJoho99AEucEntity();
        eucEntity.set申請書管理番号(entity.getShinseishoKanriNo());
        eucEntity.set保険者番号(entity.getShoKisaiHokenshaNo());
        eucEntity.set保険者名(entity.getShichosonMeisho());
        eucEntity.set被保険者番号(entity.getHihokenshaNo());
        eucEntity.set被保険者氏名(nullToEmpty(entity.getHihokenshaName()));
        eucEntity.set性別コード(nullToEmpty(entity.getSeibetsu()));
        eucEntity.set性別((entity.getSeibetsu() != null && !entity.getSeibetsu().isEmpty())
                ? Gender.toValue(entity.getSeibetsu().value()).getCommonName() : RString.EMPTY);
        eucEntity.set生年月日(format日付(entity.getSeinengappiYMD()));
        eucEntity.set年齢(new RString(entity.getAge()));
        eucEntity.set被保険者区分コード(entity.getHihokenshaKubunCode());
        eucEntity.set被保険者区分((entity.getHihokenshaKubunCode() != null && !entity.getHihokenshaKubunCode().trim().isEmpty())
                ? HihokenshaKubunCode.toValue(entity.getHihokenshaKubunCode()).get名称() : RString.EMPTY);
        eucEntity.set_２号特定疾病コード(entity.getNigoTokuteiShippeiCode());
        eucEntity.set_２号特定疾病名((entity.getNigoTokuteiShippeiCode() != null && !entity.getNigoTokuteiShippeiCode().trim().isEmpty())
                ? TokuteiShippei.toValue(entity.getNigoTokuteiShippeiCode()).get名称() : RString.EMPTY);
        eucEntity.set申請日(format日付(entity.getNinteiShinseiYMD()));
        eucEntity.set申請書区分コード(entity.getShienShinseiKubun());
        eucEntity.set申請書区分((entity.getShienShinseiKubun() != null && !entity.getShienShinseiKubun().trim().isEmpty())
                ? ShienShinseiKubun.toValue(entity.getShienShinseiKubun()).get名称() : RString.EMPTY);
        eucEntity.set申請区分_法令_コード(nullToEmpty(entity.getNinteiShinseiHoreiKubunCode()));
        eucEntity.set申請区分_法令((entity.getNinteiShinseiHoreiKubunCode() != null && !entity.getNinteiShinseiHoreiKubunCode().isEmpty())
                ? NinteiShinseiHoreiCode.toValue(entity.getNinteiShinseiHoreiKubunCode().value()).get名称() : RString.EMPTY);
        eucEntity.set申請区分_申請時_コード(nullToEmpty(entity.getNinteiShinseiShinseijiKubunCode()));
        eucEntity.set申請区分_申請時((entity.getNinteiShinseiShinseijiKubunCode() != null && !entity.getNinteiShinseiShinseijiKubunCode().isEmpty())
                ? NinteiShinseiShinseijiKubunCode.toValue(entity.getNinteiShinseiShinseijiKubunCode().value()).get名称() : RString.EMPTY);
        eucEntity.set処理状態区分コード(nullToEmpty(entity.getShoriJotaiKubun()));
        eucEntity.set処理状態区分((entity.getShoriJotaiKubun() != null && !entity.getShoriJotaiKubun().isEmpty())
                ? ShoriJotaiKubun.toValue(entity.getShoriJotaiKubun().value()).get名称() : RString.EMPTY);
        eucEntity.set申請時_医療機関コード(entity.getShinseiShujiiIryokikanCode());
        eucEntity.set申請時_医療機関名称(entity.getShinseiIryoKikanMeisho());
        eucEntity.set申請時_主治医コード(entity.getShinseiShujiiCode());
        eucEntity.set申請時_主治医名(entity.getShinseiShujiiName());
        eucEntity.set依頼区分コード(entity.getIkenshoIraiKubun());
        eucEntity.set依頼区分((entity.getIkenshoIraiKubun() != null && !entity.getIkenshoIraiKubun().trim().isEmpty())
                ? IkenshoIraiKubun.toValue(entity.getIkenshoIraiKubun()).get名称() : RString.EMPTY);
        eucEntity.set依頼時_医療機関コード(entity.getIraiShujiiIryokikanCode());
        eucEntity.set依頼時_医療機関名称(entity.getIraiIryoKikanMeisho());
        eucEntity.set依頼時_主治医コード(entity.getIraiShujiiCode());
        eucEntity.set依頼時_主治医名(entity.getIraiShujiiName());
        eucEntity.set依頼時_医師区分コード(entity.getIraiIshiKubunCode());
        eucEntity.set依頼時_医師区分((entity.getIraiIshiKubunCode() != null && !entity.getIraiIshiKubunCode().trim().isEmpty())
                ? IshiKubunCode.toValue(entity.getIraiIshiKubunCode()).get名称() : RString.EMPTY);
        eucEntity.set入手時_医療機関コード(entity.getNyushuShujiiIryokikanCode());
        eucEntity.set入手時_医療機関名称(entity.getNyushuIryoKikanMeisho());
        eucEntity.set入手時_主治医コード(entity.getNyushuShujiiCode());
        eucEntity.set入手時_主治医名(entity.getNyushuShujiiName());
        eucEntity.set受領日(format日付(entity.getIkenshoJuryoYMD()));
        eucEntity.set記入日(format日付(entity.getIkenshoKinyuYMD()));
        eucEntity.set読取日(format日付(entity.getIkenshoReadYMD()));
        eucEntity.set最終診療日(format日付(entity.getSaishuShinryoYMD()));
        eucEntity.set意見書同意(IsIkenshoDoiUmu.toValue(entity.isIkenshoDoiFlag()).get名称());
        eucEntity.set意見書作成回数区分コード(nullToEmpty(entity.getIkenshoSakuseiKaisuKubun()));
        eucEntity.set意見書作成回数区分((entity.getIkenshoSakuseiKaisuKubun() != null && !entity.getIkenshoSakuseiKaisuKubun().isEmpty())
                ? IkenshoSakuseiKaisuKubun.toValue(entity.getIkenshoSakuseiKaisuKubun().value()).get名称() : RString.EMPTY);
        eucEntity.set在宅or施設区分コード(nullToEmpty(entity.getZaitakuShisetsuKubun()));
        eucEntity.set在宅or施設区分((entity.getZaitakuShisetsuKubun() != null && !entity.getZaitakuShisetsuKubun().isEmpty())
                ? ZaitakuShisetsuKubun.toValue(entity.getZaitakuShisetsuKubun().value()).get名称() : RString.EMPTY);
        eucEntity.set他科受診の有無(TakaJushinUmu.toValue(entity.isExistTakaJushinFlag()).get名称());
        eucEntity.set内科受診の有無(IsNaikajJshinUmu.toValue(entity.isExistNaikaJushinFlag()).get名称());
        eucEntity.set精神科受診の有無(IsSeishinkaJushinUmu.toValue(entity.isExistSeishinkaJushinFlag()).get名称());
        eucEntity.set外科受診の有無(IsGekaJushinUmu.toValue(entity.isExistGekaJushinFlag()).get名称());
        eucEntity.set整形外科受診の有無(IsSeikeigekaJushinUmu.toValue(entity.isExistSeikeigekaJushinFlag()).get名称());
        eucEntity.set脳神経外科受診の有無(IsNoshinkeigekaJushinUmu.toValue(entity.isExistNoshinkeigekaJushinFlag()).get名称());
        eucEntity.set皮膚科受診の有無(IsHifukaJushinUmu.toValue(entity.isExistHifukaJushinFlag()).get名称());
        eucEntity.set泌尿器科受診の有無(IsHinyokikaJushinUmu.toValue(entity.isExistHinyokikaJushinFlag()).get名称());
        eucEntity.set婦人科受診の有無(IsFujinkaJushinUmu.toValue(entity.isExistFujinkaJushinFlag()).get名称());
        eucEntity.set耳鼻咽喉科受診の有無(JibiinkokajyushinUmu.toValue(entity.isExistJibiinkokaJushinFlag()).get名称());
        eucEntity.setリハビリテーション科受診の有無(RehabiritationkaJushinUmu.toValue(entity.isExistRehabilitationkaJushinFlag()).get名称());
        eucEntity.set歯科受診の有無(ShikaJushinUmu.toValue(entity.isExistShikaJushinFlag()).get名称());
        eucEntity.set眼科受診の有無(GankaJusihnUmu.toValue(entity.isExistGankaJushinFlag()).get名称());
        eucEntity.setその他受診科の有無(SonotaJushinkaUmu.toValue(entity.isExistSonotaJushinkaFlag()).get名称());
        eucEntity.setその他受診科名(entity.getSonotaJushinKaMei());
        eucEntity.set診断名１(entity.getShindamMei1());
        eucEntity.set発症日１(entity.getHasshoYMD1());
        eucEntity.set診断名２(entity.getShindamMei2());
        eucEntity.set発症日２(entity.getHasshoYMD2());
        eucEntity.set診断名３(entity.getShindamMei3());
        eucEntity.set発症日３(entity.getHasshoYMD3());
        eucEntity.set症状としての安定性コード(entity.getAnteisei());
        eucEntity.set症状としての安定性((entity.getAnteisei() != null && !entity.getAnteisei().trim().isEmpty())
                ? Anteisei.toValue(entity.getAnteisei()).get名称() : RString.EMPTY);
        eucEntity.set不安定状況(entity.getFuanteiJokyo());
        eucEntity.set治療内容(convert改行(entity.getChiryoNaiyo()));
        eucEntity.set予後の見通し(get意見項目19名称(get意見項目(意見項目List, Renban._1.getValue())));
        eucEntity.set点滴の管理(get意見項目01名称(get意見項目(意見項目List, Renban._2.getValue())));
        eucEntity.set中心静脈栄養(get意見項目01名称(get意見項目(意見項目List, Renban._3.getValue())));
        eucEntity.set透析(get意見項目01名称(get意見項目(意見項目List, Renban._4.getValue())));
        eucEntity.setストーマの処置(get意見項目01名称(get意見項目(意見項目List, Renban._5.getValue())));
        eucEntity.set酸素療法(get意見項目01名称(get意見項目(意見項目List, Renban._6.getValue())));
        eucEntity.setレスピレーター(get意見項目01名称(get意見項目(意見項目List, Renban._7.getValue())));
        eucEntity.set気管切開の処置(get意見項目01名称(get意見項目(意見項目List, Renban._8.getValue())));
        eucEntity.set疼痛の看護(get意見項目01名称(get意見項目(意見項目List, Renban._9.getValue())));
        eucEntity.set経管栄養(get意見項目01名称(get意見項目(意見項目List, Renban._10.getValue())));
        eucEntity.setモニター測定(get意見項目01名称(get意見項目(意見項目List, Renban._11.getValue())));
        eucEntity.setじょくそうの処置(get意見項目01名称(get意見項目(意見項目List, Renban._12.getValue())));
        eucEntity.setカテーテル(get意見項目01名称(get意見項目(意見項目List, Renban._13.getValue())));
        eucEntity.set寝たきり度(get意見項目02名称(get意見項目(意見項目List, Renban._14.getValue())));
        eucEntity.set認知症高齢者の日常生活自立度(get意見項目03名称(get意見項目(意見項目List, Renban._15.getValue())));
        eucEntity.set短期記憶(get意見項目04名称(get意見項目(意見項目List, Renban._16.getValue())));
        eucEntity.set認知能力(get意見項目05名称(get意見項目(意見項目List, Renban._17.getValue())));
        eucEntity.set伝達能力(get意見項目06名称(get意見項目(意見項目List, Renban._18.getValue())));
        eucEntity.set食事(get意見項目14名称(get意見項目(意見項目List, Renban._19.getValue())));
        eucEntity.set認知症の周辺症状(get意見項目07名称(get意見項目(意見項目List, Renban._20.getValue())));
        eucEntity.set幻視_幻聴(get意見項目01名称(get意見項目(意見項目List, Renban._21.getValue())));
        eucEntity.set妄想(get意見項目01名称(get意見項目(意見項目List, Renban._22.getValue())));
        eucEntity.set昼夜逆転(get意見項目01名称(get意見項目(意見項目List, Renban._23.getValue())));
        eucEntity.set暴言(get意見項目01名称(get意見項目(意見項目List, Renban._24.getValue())));
        eucEntity.set暴行(get意見項目01名称(get意見項目(意見項目List, Renban._25.getValue())));
        eucEntity.set介護への抵抗(get意見項目01名称(get意見項目(意見項目List, Renban._26.getValue())));
        eucEntity.set徘徊_問題行動(get意見項目01名称(get意見項目(意見項目List, Renban._27.getValue())));
        eucEntity.set火の不始末(get意見項目01名称(get意見項目(意見項目List, Renban._28.getValue())));
        eucEntity.set不潔行為(get意見項目01名称(get意見項目(意見項目List, Renban._29.getValue())));
        eucEntity.set異食行動(get意見項目01名称(get意見項目(意見項目List, Renban._30.getValue())));
        eucEntity.set性的問題行動(get意見項目01名称(get意見項目(意見項目List, Renban._31.getValue())));
        eucEntity.setその他(get意見項目01名称(get意見項目(意見項目List, Renban._32.getValue())));
        eucEntity.setその他_症状(get記入項目(記入項目List, Renban._1.getValue()));
        eucEntity.setその他の精神_神経症状(get意見項目07名称(get意見項目(意見項目List, Renban._33.getValue())));
        eucEntity.setその他の精神_神経症状名(get記入項目(記入項目List, Renban._2.getValue()));
        eucEntity.set専門医受診の有無(get意見項目07名称(get意見項目(意見項目List, Renban._34.getValue())));
        eucEntity.set専門医受診の有無_詳細(get記入項目(記入項目List, Renban._3.getValue()));
        eucEntity.set利き腕(get意見項目08名称(get意見項目(意見項目List, Renban._35.getValue())));
        eucEntity.set身長(get記入項目(記入項目List, Renban._4.getValue()));
        eucEntity.set体重(get記入項目(記入項目List, Renban._5.getValue()));
        eucEntity.set四肢欠損(get意見項目01名称(get意見項目(意見項目List, Renban._36.getValue())));
        eucEntity.set四肢欠損_部位(get記入項目(記入項目List, Renban._6.getValue()));
        eucEntity.set四肢欠損_程度(get意見項目10名称(get意見項目(意見項目List, Renban._37.getValue())));
        eucEntity.set麻痺(get意見項目01名称(get意見項目(意見項目List, Renban._38.getValue())));
        eucEntity.set麻痺_部位(get記入項目(記入項目List, Renban._7.getValue()));
        eucEntity.set麻痺_程度(get意見項目10名称(get意見項目(意見項目List, Renban._39.getValue())));
        eucEntity.set筋力の低下(get意見項目01名称(get意見項目(意見項目List, Renban._40.getValue())));
        eucEntity.set筋力の低下_部位(get記入項目(記入項目List, Renban._8.getValue()));
        eucEntity.set筋力の低下_程度(get意見項目10名称(get意見項目(意見項目List, Renban._41.getValue())));
        eucEntity.setじょくそう(get意見項目01名称(get意見項目(意見項目List, Renban._42.getValue())));
        eucEntity.setじょくそう_部位(get記入項目(記入項目List, Renban._9.getValue()));
        eucEntity.setじょくそう_程度(get意見項目10名称(get意見項目(意見項目List, Renban._43.getValue())));
        eucEntity.setその他の皮膚疾患(get意見項目01名称(get意見項目(意見項目List, Renban._44.getValue())));
        eucEntity.setその他の皮膚疾患_部位(get記入項目(記入項目List, Renban._10.getValue()));
        eucEntity.setその他の皮膚疾患_程度(get意見項目10名称(get意見項目(意見項目List, Renban._45.getValue())));
        eucEntity.set関節の拘縮(get意見項目01名称(get意見項目(意見項目List, Renban._46.getValue())));
        eucEntity.set関節の拘縮_肩関節_右(get意見項目10名称(get意見項目(意見項目List, Renban._47.getValue())));
        eucEntity.set関節の拘縮_肩関節_左(get意見項目10名称(get意見項目(意見項目List, Renban._48.getValue())));
        eucEntity.set関節の拘縮_股関節_右(get意見項目10名称(get意見項目(意見項目List, Renban._49.getValue())));
        eucEntity.set関節の拘縮_股関節_左(get意見項目10名称(get意見項目(意見項目List, Renban._50.getValue())));
        eucEntity.set関節の拘縮_肘関節_右(get意見項目10名称(get意見項目(意見項目List, Renban._51.getValue())));
        eucEntity.set関節の拘縮_肘関節_左(get意見項目10名称(get意見項目(意見項目List, Renban._52.getValue())));
        eucEntity.set関節の拘縮_膝関節_右(get意見項目10名称(get意見項目(意見項目List, Renban._53.getValue())));
        eucEntity.set関節の拘縮_膝関節_左(get意見項目10名称(get意見項目(意見項目List, Renban._54.getValue())));
        eucEntity.set失調_不随意運動(get意見項目01名称(get意見項目(意見項目List, Renban._55.getValue())));
        eucEntity.set失調_不随意運動_上肢_右(get意見項目01名称(get意見項目(意見項目List, Renban._56.getValue())));
        eucEntity.set失調_不随意運動_上肢_左(get意見項目01名称(get意見項目(意見項目List, Renban._57.getValue())));
        eucEntity.set失調_不随意運動_体幹_右(get意見項目01名称(get意見項目(意見項目List, Renban._58.getValue())));
        eucEntity.set失調_不随意運動_体幹_左(get意見項目01名称(get意見項目(意見項目List, Renban._59.getValue())));
        eucEntity.set失調_不随意運動_下肢_右(get意見項目01名称(get意見項目(意見項目List, Renban._60.getValue())));
        eucEntity.set失調_不随意運動_下肢_左(get意見項目01名称(get意見項目(意見項目List, Renban._61.getValue())));
        eucEntity.set尿失禁(get意見項目01名称(get意見項目(意見項目List, Renban._62.getValue())));
        eucEntity.set転倒_骨折(get意見項目01名称(get意見項目(意見項目List, Renban._63.getValue())));
        eucEntity.set徘徊_可能性が高い病態(get意見項目01名称(get意見項目(意見項目List, Renban._64.getValue())));
        eucEntity.set褥瘡(get意見項目01名称(get意見項目(意見項目List, Renban._65.getValue())));
        eucEntity.set嚥下性肺炎(get意見項目01名称(get意見項目(意見項目List, Renban._66.getValue())));
        eucEntity.set腸閉塞(get意見項目01名称(get意見項目(意見項目List, Renban._67.getValue())));
        eucEntity.set易感染性(get意見項目01名称(get意見項目(意見項目List, Renban._68.getValue())));
        eucEntity.set心肺機能の低下(get意見項目01名称(get意見項目(意見項目List, Renban._69.getValue())));
        eucEntity.setがん等による疼痛(get意見項目01名称(get意見項目(意見項目List, Renban._70.getValue())));
        eucEntity.set脱水(get意見項目01名称(get意見項目(意見項目List, Renban._71.getValue())));
        eucEntity.set病態_その他(get意見項目01名称(get意見項目(意見項目List, Renban._72.getValue())));
        eucEntity.set病態_その他_詳細(get記入項目(記入項目List, Renban._11.getValue()));
        eucEntity.set病態_対処方針(get記入項目(記入項目List, Renban._12.getValue()));
        eucEntity.set訪問診療(get意見項目01名称(get意見項目(意見項目List, Renban._73.getValue())));
        eucEntity.set訪問診療_必要性(get意見項目01名称(get意見項目(意見項目List, Renban._74.getValue())));
        eucEntity.set訪問看護(get意見項目01名称(get意見項目(意見項目List, Renban._75.getValue())));
        eucEntity.set訪問看護_必要性(get意見項目01名称(get意見項目(意見項目List, Renban._76.getValue())));
        eucEntity.set訪問リハビリテーション(get意見項目01名称(get意見項目(意見項目List, Renban._77.getValue())));
        eucEntity.set訪問リハビリテーション_必要性(get意見項目01名称(get意見項目(意見項目List, Renban._78.getValue())));
        eucEntity.set通所リハビリテーション(get意見項目01名称(get意見項目(意見項目List, Renban._79.getValue())));
        eucEntity.set通所リハビリテーション_必要性(get意見項目01名称(get意見項目(意見項目List, Renban._80.getValue())));
        eucEntity.set短期入所療養介護(get意見項目01名称(get意見項目(意見項目List, Renban._81.getValue())));
        eucEntity.set短期入所療養介護_必要性(get意見項目01名称(get意見項目(意見項目List, Renban._82.getValue())));
        eucEntity.set訪問歯科診療(get意見項目01名称(get意見項目(意見項目List, Renban._83.getValue())));
        eucEntity.set訪問歯科診療_必要性(get意見項目01名称(get意見項目(意見項目List, Renban._84.getValue())));
        eucEntity.set訪問歯科衛生指導(get意見項目01名称(get意見項目(意見項目List, Renban._85.getValue())));
        eucEntity.set訪問歯科衛生指導_必要性(get意見項目01名称(get意見項目(意見項目List, Renban._86.getValue())));
        eucEntity.set訪問薬剤管理指導(get意見項目01名称(get意見項目(意見項目List, Renban._87.getValue())));
        eucEntity.set訪問薬剤管理指導_必要性(get意見項目01名称(get意見項目(意見項目List, Renban._88.getValue())));
        eucEntity.set訪問栄養食事指導(get意見項目01名称(get意見項目(意見項目List, Renban._89.getValue())));
        eucEntity.set訪問栄養食事指導_必要性(get意見項目01名称(get意見項目(意見項目List, Renban._90.getValue())));
        eucEntity.setその他の医療系のサービス(get意見項目01名称(get意見項目(意見項目List, Renban._91.getValue())));
        eucEntity.setその他の医療系のサービス_詳細(get記入項目(記入項目List, Renban._13.getValue()));
        eucEntity.setその他の医療系のサービス_必要性(get意見項目01名称(get意見項目(意見項目List, Renban._92.getValue())));
        eucEntity.set介護サービスの留意事項_血圧(get意見項目17名称(get意見項目(意見項目List, Renban._93.getValue())));
        eucEntity.set介護サービスの留意事項_血圧_詳細(get記入項目(記入項目List, Renban._14.getValue()));
        eucEntity.set介護サービスの留意事項_嚥下(get意見項目17名称(get意見項目(意見項目List, Renban._94.getValue())));
        eucEntity.set介護サービスの留意事項_嚥下_詳細(get記入項目(記入項目List, Renban._15.getValue()));
        eucEntity.set介護サービスの留意事項_摂食(get意見項目17名称(get意見項目(意見項目List, Renban._95.getValue())));
        eucEntity.set介護サービスの留意事項_摂食_詳細(get記入項目(記入項目List, Renban._16.getValue()));
        eucEntity.set介護サービスの留意事項_移動(get意見項目17名称(get意見項目(意見項目List, Renban._96.getValue())));
        eucEntity.set介護サービスの留意事項_移動_詳細(get記入項目(記入項目List, Renban._17.getValue()));
        eucEntity.set介護サービスの留意事項_その他(get記入項目(記入項目List, Renban._18.getValue()));
        eucEntity.set感染症の有無(get意見項目18名称(get意見項目(意見項目List, Renban._97.getValue())));
        eucEntity.set感染症の有無_詳細(get記入項目(記入項目List, Renban._19.getValue()));
        eucEntity.set特記事項(convert改行(entity.getTokkiJiko()));
        eucEntity.set二次判定結果の連絡確認((entity.isNijiHanteiKekkaRenrakuFlag()) ? new RString("必要") : new RString("不要"));
        eucEntity.set意見書メモ(convert改行(entity.getIkenshoMemo()));
        return eucEntity;
    }

    private static RString get記入項目(List<DbT5303ShujiiIkenshoKinyuItemEntity> 記入項目List, int 連番) {
        for (DbT5303ShujiiIkenshoKinyuItemEntity 記入項目 : 記入項目List) {
            if (記入項目.getRemban() == 連番) {
                return 記入項目.getKinyuItem();
            }
        }
        return RString.EMPTY;
    }

    private static RString get意見項目(List<DbT5304ShujiiIkenshoIkenItemEntity> 意見項目List, int 連番) {
        for (DbT5304ShujiiIkenshoIkenItemEntity 意見項目 : 意見項目List) {
            if (意見項目.getRemban() == 連番) {
                return 意見項目.getIkenItem();
            }
        }
        return RString.EMPTY;
    }

    private static RString get意見項目01名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku01.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目02名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku02.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目03名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku03.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目04名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku04.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目05名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku05.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目06名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku06.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目07名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku07.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目08名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku08.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目10名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku10.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目14名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku14.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目17名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku17.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目18名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku18.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目19名称(RString code) {
        return (code != null && !code.trim().isEmpty()) ? IkenKomoku19.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString format日付(FlexibleDate value) {
        return (value != null)
                ? value.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString()
                : RString.EMPTY;
    }

    private static RString convert改行(RString text) {
        return (text != null)
                ? new RStringBuilder(text).replace(改行, 下矢印).toRString()
                : RString.EMPTY;
    }

    private static RString nullToEmpty(Code item) {
        return (item != null) ? item.value() : RString.EMPTY;
    }

    private static RString nullToEmpty(AtenaMeisho item) {
        return (item != null) ? item.value() : RString.EMPTY;
    }
}
