/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ZenzenkayiJyohouEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoItem;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 委員用一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IchijihanteikekkahyoItemSettei {

    private static final RString 月間 = new RString("月間");
    private static final RString A_99 = new RString("99A");
    private static final RString A_02 = new RString("02A");
    private static final RString A_06 = new RString("06A");
    private static final RString A_09 = new RString("09A");
    private static final RString B_09 = new RString("09B");
    private static final RString 特記事項有 = new RString("※");
    private static final RString 印字する = new RString("1");
    private static final int 連番_1 = 1;
    private static final int 連番_2 = 2;
    private static final int 連番_3 = 3;
    private static final int 連番_4 = 4;
    private static final int 連番_5 = 5;
    private static final int 連番_6 = 6;
    private static final int 連番_7 = 7;
    private static final int 連番_8 = 8;
    private static final int 連番_9 = 9;
    private static final int 連番_10 = 10;
    private static final int 連番_11 = 11;
    private static final int 連番_12 = 12;
    private static final int 連番_13 = 13;
    private static final int 連番_14 = 14;
    private static final int 連番_15 = 15;
    private static final int 連番_16 = 16;
    private static final int 連番_17 = 17;
    private static final int 連番_18 = 18;
    private static final int 連番_19 = 19;
    private static final int 連番_20 = 20;

    /**
     * 委員用一次判定結果票Entityの設定。
     *
     * @param entity ItiziHanteiEntity
     * @param 特記事項情報 List<NinteichosahyoTokkijikoEntity>
     * @param paramter IinTokkiJikouItiziHanteiProcessParameter
     * @param itiziHanteiEntityList List<ItiziHanteiEntity>
     * @param entityList List<DbT5211NinteichosahyoChosaItemEntity>
     * @param dbT5116Entity DbT5116IchijiHanteiKekkaJohoEntity
     * @param zenzenkayiJyohou ZenzenkayiJyohouEntity
     * @return 委員用一次判定結果票のEntity
     */
    public IchijihanteikekkahyoItem set項目(ItiziHanteiEntity entity, List<NinteichosahyoTokkijikoEntity> 特記事項情報,
            IinTokkiJikouItiziHanteiProcessParameter paramter, List<ItiziHanteiEntity> itiziHanteiEntityList,
            List<DbT5211NinteichosahyoChosaItemEntity> entityList, DbT5116IchijiHanteiKekkaJohoEntity dbT5116Entity,
            ZenzenkayiJyohouEntity zenzenkayiJyohou) {
        IchijihanteikekkahyoItemHensyu itemHensyu = new IchijihanteikekkahyoItemHensyu();
        IchijihanteikekkahyoItem item = new IchijihanteikekkahyoItem();
        IchijihanteikekkahyoItemSetteiTwo itemSetteiTwo = new IchijihanteikekkahyoItemSetteiTwo();
        RString 厚労省IF識別コード = entity.getDbt5101_koroshoIfShikibetsuCode().value();

        item.set申請書管理番号(entity.getDbt5502_shinseishoKanriNo().value());
        item.set帳票名(new RString("認定情報　（事務局用）"));
        item.set審査会審査順(new RString(entity.getDbt5502_shinsakaiOrder()));
        item.set現在の状況(itemSetteiTwo.get現在の状況(new RString(entity.getDbt5210_remban()),
                entity.getDbt5210_koroshoIfShikibetsuCode().value(), 厚労省IF識別コード));
        item.set審査人数(new RString(entity.getDbt5502_shinsakaiOrder()));
        item.set合議体番号(paramter.getGogitaiNo());
        item.set被保険者区分(HihokenshaKubunCode.toValue(entity.getDbt5101_hihokenshaKubunCode()).get名称());
        item.set年齢(new RString(entity.getDbt5101_age()));
        item.set前々回要介護度(zenzenkayiJyohou.getZenYokaigoKubunCode() == null || zenzenkayiJyohou.getZenYokaigoKubunCode().isEmpty()
                ? RString.EMPTY : YokaigoJotaiKubun09.toValue(zenzenkayiJyohou.getZenYokaigoKubunCode().value()).get名称());
        item.set前々回認定有効期間(前々回認定有効期間(zenzenkayiJyohou.getNijiHanteiNinteiYukoKikan()));
        item.set前々回認定有効期間開始年月日(パターン17(zenzenkayiJyohou.getNijiHanteiNinteiYukoKaishiYMD()));
        item.set前々回認定有効期間終了年月日(パターン17(zenzenkayiJyohou.getNijiHanteiNinteiYukoShuryoYMD()));
        item.set前回認定有効期間(前々回認定有効期間(entity.getDbt5101_zenkaiYukoKikanStart(), entity.getDbt5101_zenkaiYukoKikanEnd()));
        item.set前回認定有効期間開始年月日(パターン17(entity.getDbt5101_zenkaiYukoKikanStart()));
        item.set前回認定有効期間終了年月日(パターン17(entity.getDbt5101_zenkaiYukoKikanEnd()));
        item.set前回認定日(パターン16(entity.getDbt5101_zenkaiNinteiYMD()));
        item.set審査会資料作成年月日(FlexibleDate.getNowDate());
        item.set今回認定申請年月日(entity.getDbt5101_ninteiShinseiYMD());
        item.set今回認定調査実施年月日(entity.getDbt5202_ninteichosaJisshiYMD());
        item.set今回認定審査年月日(entity.getDbt5502_shinsakaiKaisaiYMD());
        item.set要介護認定等基準時間(new RString(entity.getDbt5116_kijunJikan()));
        item.set要介護認定等基準時間_食事(new RString(entity.getDbt5116_kijunJikanShokuji()));
        item.set要介護認定等基準時間_排泄(new RString(entity.getDbt5116_kijunJikanHaisetsu()));
        item.set要介護認定等基準時間_移動(new RString(entity.getDbt5116_kijunJikanIdo()));
        item.set要介護認定等基準時間_清潔保持(new RString(entity.getDbt5116_kijunJikanSeiketsuHoji()));
        item.set要介護認定等基準時間_間接(new RString(entity.getDbt5116_kijunJikanKansetsuCare()));
        item.set要介護認定等基準時間_BPSD関連(new RString(entity.getDbt5116_kijunJikanBPSDKanren()));
        item.set要介護認定等基準時間_機能訓練(new RString(entity.getDbt5116_kijunJikanKinoKunren()));
        item.set要介護認定等基準時間_医療関連(new RString(entity.getDbt5116_kijunJikanIryoKanren()));
        item.set要介護認定等基準時間_認知症加算(new RString(entity.getDbt5116_kijunJikanNinchishoKasan()));
        item.set警告コード(entity.getDbt5116_ichijiHnateiKeikokuCode());
        item.set認定調査実施場所名称(entity.getDbt5202_chosaJisshiBashoMeisho());
        item.set中間評価項目得点表第1群(new RString(entity.getDbt5116_chukanHyokaKomoku1gun()));
        item.set中間評価項目得点表第2群(new RString(entity.getDbt5116_chukanHyokaKomoku2gun()));
        item.set中間評価項目得点表第3群(new RString(entity.getDbt5116_chukanHyokaKomoku3gun()));
        item.set中間評価項目得点表第4群(new RString(entity.getDbt5116_chukanHyokaKomoku4gun()));
        item.set中間評価項目得点表第5群(new RString(entity.getDbt5116_chukanHyokaKomoku5gun()));
        item.set前回中間評価項目得点表第1群(new RString(dbT5116Entity.getChukanHyokaKomoku1gun()));
        item.set前回中間評価項目得点表第2群(new RString(dbT5116Entity.getChukanHyokaKomoku2gun()));
        item.set前回中間評価項目得点表第3群(new RString(dbT5116Entity.getChukanHyokaKomoku3gun()));
        item.set前回中間評価項目得点表第4群(new RString(dbT5116Entity.getChukanHyokaKomoku4gun()));
        item.set前回中間評価項目得点表第5群(new RString(dbT5116Entity.getChukanHyokaKomoku5gun()));
        item.set障害高齢者自立度_ある(get障害高齢者自立度_ある(厚労省IF識別コード, 特記事項情報));
        item.set認知症高齢者自立度_ある(get認知症高齢者自立度_ある(厚労省IF識別コード, 特記事項情報));
        item.set認知症自立度Ⅱ以上の蓋然性(new RString(entity.getDbt5116_iIijoNoGaizensei().intValue()));
        RString dbt5207厚労省IF識別コード = entity.getDbt5207_koroshoIfShikibetsuCode().value();
        if (ServiceKubunCode.予防給付サービス.getコード().equals(entity.getDbt5202_serviceKubunCode().value())) {
            item = set介護給付サービス(item, dbt5207厚労省IF識別コード, 厚労省IF識別コード, entity, itiziHanteiEntityList);
        } else if (ServiceKubunCode.介護給付サービス.getコード().equals(entity.getDbt5202_serviceKubunCode().value())) {
            item = set予防給付サービス(item, dbt5207厚労省IF識別コード, 厚労省IF識別コード, entity, itiziHanteiEntityList);
        }
        RString dbT5211厚労省IF識別コード = entity.getDbt5211_koroshoIfShikibetsuCode().value();
        item = コード転換(item, entity);
        for (ItiziHanteiEntity itiziHanteiEntity : itiziHanteiEntityList) {
            if (entity.getDbt5502_shinseishoKanriNo().equals(itiziHanteiEntity.getDbt5502_shinseishoKanriNo())) {
                if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.今回基本調査項目結果の正常選択肢印刷有無,
                        RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                    item = set項目(厚労省IF識別コード, itemHensyu, dbT5211厚労省IF識別コード, 特記事項情報, itiziHanteiEntity, item);
                    item = set調査結果1(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity, 特記事項情報, itemHensyu);
                    item = set調査結果2(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity, 特記事項情報, itemHensyu);
                    item = set調査結果3(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity, 特記事項情報, itemHensyu);
                    item = set調査結果4(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity, 特記事項情報, itemHensyu);
                }
                if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.前回との結果比較印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                    item = itemSetteiTwo.set認定調査と主治医意見書の結果比較(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
                }
            }
        }
        if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.今回前回比較で変化有で前回正常選択肢表示印刷有無,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            itemSetteiTwo.set前回結果(item, entityList);
        }
        if (印字する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査と主治医意見書の結果比較印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            itemSetteiTwo.set段階改善(item, itemHensyu);
        }
        return item;
    }

    private IchijihanteikekkahyoItem set項目(RString 厚労省IF識別コード, IchijihanteikekkahyoItemHensyu itemHensyu,
            RString dbT5211厚労省IF識別コード,
            List<NinteichosahyoTokkijikoEntity> 特記事項情報, ItiziHanteiEntity itiziHanteiEntity, IchijihanteikekkahyoItem item) {
        IchijihanteikekkahyoItemSetteiThree setteiThree = new IchijihanteikekkahyoItemSetteiThree();
        if (dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_麻痺_左_上肢(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_麻痺_左_上肢_ある(get麻痺特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_麻痺_左_上肢(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_麻痺_右_上肢(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_麻痺_右_上肢_ある(get麻痺特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_麻痺_右_上肢(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_麻痺_左_下肢(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_麻痺_左_下肢_ある(get麻痺特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_麻痺_左_下肢(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_麻痺_右_下肢(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_麻痺_右_下肢_ある(get麻痺特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_麻痺_右_下肢(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_麻痺_その他(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_麻痺_その他_ある(get麻痺特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_麻痺_その他(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_拘縮_肩関節(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_拘縮_肩関節_ある(get拘縮の有無特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_拘縮_肩関節(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_拘縮_股関節(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_拘縮_股関節_ある(get拘縮の有無特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_拘縮_股関節(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_拘縮_膝関節(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_拘縮_膝関節_ある(get拘縮の有無特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_拘縮_膝関節(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_拘縮_その他(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_拘縮_その他_ある(get拘縮の有無特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_拘縮_その他(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_寝返り(ChosaAnser02.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_寝返り_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("寝返り")));
                itemHensyu.set調査結果_寝返り(ChosaAnser02.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_起き上がり(ChosaAnser02.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_起き上がり_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("起き上がり")));
                itemHensyu.set調査結果_起き上がり(ChosaAnser02.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get座位保持(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_座位保持(ChosaAnser03.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_座位保持_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("座位保持")));
                itemHensyu.set調査結果_座位保持(ChosaAnser03.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set調査結果4(IchijihanteikekkahyoItem item, RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード,
            ItiziHanteiEntity itiziHanteiEntity, List<NinteichosahyoTokkijikoEntity> 特記事項情報, IchijihanteikekkahyoItemHensyu itemHensyu) {
        IchijihanteikekkahyoItemSetteiThree setteiThree = new IchijihanteikekkahyoItemSetteiThree();
        if (dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            if (setteiThree.get集団への不適応(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_集団への不適応(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_集団への不適応_ある(get集団への不適応特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_集団への不適応(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get買い物(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_買い物(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_買い物_ある(get買い物特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_買い物(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get簡単な調理(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_簡単な調理(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_簡単な調理_ある(get簡単な調理特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_簡単な調理(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_点滴の管理(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_点滴の管理_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("点滴の管理")));
                itemHensyu.set調査結果_点滴の管理(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_中心静脈栄養(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_中心静脈栄養_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("中心静脈栄養")));
                itemHensyu.set調査結果_中心静脈栄養(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_透析(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_透析_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("透析")));
                itemHensyu.set調査結果_透析(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_ストーマの処置(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_ストーマの処置_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("ストーマの処置")));
                itemHensyu.set調査結果_ストーマの処置(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_酸素療法(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_酸素療法_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("酸素療法")));
                itemHensyu.set調査結果_酸素療法(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_レスピレーター(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_レスピレーター_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("レスピレーター")));
                itemHensyu.set調査結果_レスピレーター(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get気管切開の処置(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_気管切開の処置(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_気管切開の処置_ある(get気管切開の処置特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_気管切開の処置(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_疼痛の看護(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_疼痛の看護_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("疼痛の看護")));
                itemHensyu.set調査結果_気管切開の処置(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_経管栄養(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_経管栄養_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("経管栄養")));
                itemHensyu.set調査結果_経管栄養(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.getモニター測定(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_モニター測定(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_モニター測定_ある(getモニター測定特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_モニター測定(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.getじょくそうの処置(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_じょくそうの処置(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_じょくそうの処置_ある(getじょくそうの処置特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_じょくそうの処置(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.getカテーテル(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_カテーテル(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_カテーテル_ある(getカテーテル特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_カテーテル(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set調査結果3(IchijihanteikekkahyoItem item, RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード,
            ItiziHanteiEntity itiziHanteiEntity, List<NinteichosahyoTokkijikoEntity> 特記事項情報, IchijihanteikekkahyoItemHensyu itemHensyu) {
        IchijihanteikekkahyoItemSetteiThree setteiThree = new IchijihanteikekkahyoItemSetteiThree();
        if (dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            if (setteiThree.get同じ話をする(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_同じ話をする(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_同じ話をする_ある(get同じ話をする特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_同じ話をする(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get大声を出す(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_大声を出す(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_大声を出す_ある(get大声を出す特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_大声を出す(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get介護に抵抗(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_介護に抵抗(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_介護に抵抗_ある(get介護に抵抗特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_介護に抵抗(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get落ち着きなし(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_落ち着きなし(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_落ち着きなし_ある(get落ち着きなし特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_落ち着きなし(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get一人で出たがる(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_一人で出たがる(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_一人で出たがる_ある(get一人で出たがる特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_一人で出たがる(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get収集癖(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_収集癖(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_収集癖_ある(get収集癖特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_収集癖(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get物や衣類を壊す(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_物や衣類を壊す(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_物や衣類を壊す_ある(get物や衣類を壊す特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_物や衣類を壊す(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.getひどい物忘れ(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_ひどい物忘れ(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_ひどい物忘れ_ある(getひどい物忘れ特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_ひどい物忘れ(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get独り言_独り笑い(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_独り言_独り笑い(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_独り言_独り笑い_ある(get独り言_独り笑い特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_独り言_独り笑い(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get自分勝手に行動する(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_自分勝手に行動する(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_自分勝手に行動する_ある(get自分勝手に行動する特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_自分勝手に行動する(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get話がまとまらない(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_話がまとまらない(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_話がまとまらない_ある(get話がまとまらない特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_話がまとまらない(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get薬の内服(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_薬の内服(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_薬の内服_ある(get薬の内服特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_薬の内服(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get金銭の管理(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_金銭の管理(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_金銭の管理_ある(get金銭の管理特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_金銭の管理(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get日常の意思決定(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_日常の意思決定(ChosaAnser17.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_日常の意思決定_ある(get日常の意思決定特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_日常の意思決定(ChosaAnser17.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set調査結果2(IchijihanteikekkahyoItem item, RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード,
            ItiziHanteiEntity itiziHanteiEntity, List<NinteichosahyoTokkijikoEntity> 特記事項情報, IchijihanteikekkahyoItemHensyu itemHensyu) {
        IchijihanteikekkahyoItemSetteiThree setteiThree = new IchijihanteikekkahyoItemSetteiThree();
        if (dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_整髪(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_整髪_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("整髪")));
                itemHensyu.set調査結果_整髪(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_上衣の着脱(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_上衣の着脱_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("上衣の着脱")));
                itemHensyu.set調査結果_上衣の着脱(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.getズボン等の着脱(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_ズボン等の着脱(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_ズボン等の着脱_ある(getズボン等の着脱特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_ズボン等の着脱(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get外出頻度(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_外出頻度(ChosaAnser13.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_外出頻度_ある(get外出頻度特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_外出頻度(ChosaAnser13.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get意思の伝達(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_意思の伝達(ChosaAnser14.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_意思の伝達_ある(get意思の伝達特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_意思の伝達(ChosaAnser14.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get毎日の日課を理解(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_毎日の日課を理解(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_毎日の日課を理解_ある(get毎日の日課を理解特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_毎日の日課を理解(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get生年月日をいう(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_生年月日をいう(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_生年月日をいう_ある(get生年月日をいう特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_生年月日をいう(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get短期記憶(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_短期記憶(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_短期記憶_ある(get短期記憶特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_短期記憶(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get自分の名前をいう(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_自分の名前をいう(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_自分の名前をいう_ある(get自分の名前をいう特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_自分の名前をいう(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get今の季節を理解(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_今の季節を理解(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_今の季節を理解_ある(get今の季節を理解特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_今の季節を理解(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get場所の理解(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_場所の理解(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_場所の理解_ある(get場所の理解特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_場所の理解(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get徘徊(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_徘徊(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_徘徊_ある(get徘徊特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_徘徊(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get外出して戻れない(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_外出して戻れない(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_外出して戻れない_ある(get外出して戻れない特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_外出して戻れない(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get被害的(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_被害的(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_被害的_ある(get被害的特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_被害的(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get作話(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_作話(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_作話_ある(get作話特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_作話(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get感情が不安定(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_感情が不安定(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_感情が不安定_ある(get感情が不安定特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_感情が不安定(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get昼夜逆転(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_昼夜逆転(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_昼夜逆転_ある(get昼夜逆転特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_昼夜逆転(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set調査結果1(IchijihanteikekkahyoItem item, RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード,
            ItiziHanteiEntity itiziHanteiEntity, List<NinteichosahyoTokkijikoEntity> 特記事項情報, IchijihanteikekkahyoItemHensyu itemHensyu) {
        IchijihanteikekkahyoItemSetteiThree setteiThree = new IchijihanteikekkahyoItemSetteiThree();
        if (dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_両足での立位(ChosaAnser04.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_両足での立位_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("両足での立位保持")));
                itemHensyu.set調査結果_両足での立位(ChosaAnser04.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_歩行(ChosaAnser02.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_歩行_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("歩行")));
                itemHensyu.set調査結果_歩行(ChosaAnser02.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_立ち上がり(ChosaAnser02.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_立ち上がり_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("立ち上がり")));
                itemHensyu.set調査結果_立ち上がり(ChosaAnser02.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_片足での立位(ChosaAnser04.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_片足での立位_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("片足での立位")));
                itemHensyu.set調査結果_片足での立位(ChosaAnser04.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_洗身(ChosaAnser06.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_洗身_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("洗身")));
                itemHensyu.set調査結果_洗身(ChosaAnser06.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_つめ切り(ChosaAnser07.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_つめ切り_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("つめ切り")));
                itemHensyu.set調査結果_つめ切り(ChosaAnser07.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_視力(ChosaAnser08.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_視力_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("視力")));
                itemHensyu.set調査結果_視力(ChosaAnser08.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_聴力(ChosaAnser09.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_聴力_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("聴力")));
                itemHensyu.set調査結果_聴力(ChosaAnser09.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_移乗(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_移乗_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("移乗")));
                itemHensyu.set調査結果_移乗(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_移動(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_移動_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("移動")));
                itemHensyu.set調査結果_移動(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.getえん下(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_えん下(ChosaAnser11.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_えん下_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("えん下")));
                itemHensyu.set調査結果_えん下(ChosaAnser11.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_食事摂取(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_食事摂取_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("食事摂取")));
                itemHensyu.set調査結果_食事摂取(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get排尿(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_排尿(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_排尿_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("排尿")));
                itemHensyu.set調査結果_排尿(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (setteiThree.get排便(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_排便(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_排便_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("排便")));
                itemHensyu.set調査結果_排便(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_口腔清潔(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_口腔清潔_ある(get口腔清潔特記事項_ある(厚労省IF識別コード, 特記事項情報));
                itemHensyu.set調査結果_口腔清潔(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            } else if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))) {
                item.set調査結果_洗顔(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_洗顔_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("洗顔")));
                itemHensyu.set調査結果_洗顔(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード());
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set予防給付サービス(IchijihanteikekkahyoItem item, RString dbt5207厚労省IF識別コード,
            RString 厚労省IF識別コード, ItiziHanteiEntity entity, List<ItiziHanteiEntity> itiziHanteiEntityList) {
        for (ItiziHanteiEntity itiziHanteiEntity : itiziHanteiEntityList) {
            if (dbt5207厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5101_koroshoIfShikibetsuCode().value())
                    && entity.getDbt5202_serviceKubunCode().equals(itiziHanteiEntity.getDbt5202_serviceKubunCode())) {
                if (連番_1 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set訪問介護_ホームヘルプサービス(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (連番_2 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set訪問入浴介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (連番_3 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set訪問看護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (連番_4 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set訪問リハビリテーション(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (連番_5 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set居宅療養管理指導(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (連番_6 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set通所介護_デイサービス(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (連番_7 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set通所リハビリテーション(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (A_99.equals(厚労省IF識別コード) || A_02.equals(厚労省IF識別コード)) {
                    item = set予防給付サービス_A_99_A_02(item, itiziHanteiEntity);
                } else if (B_09.equals(厚労省IF識別コード) && 連番_19 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set定期巡回_随時対応型訪問介護看護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (B_09.equals(厚労省IF識別コード) && 連番_20 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set看護小規模多機能型居宅介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                item = set予防給付サービス_A_06_A_09_B_09(item, itiziHanteiEntity, 厚労省IF識別コード);
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set予防給付サービス_A_06_A_09_B_09(IchijihanteikekkahyoItem item,
            ItiziHanteiEntity itiziHanteiEntity, RString 厚労省IF識別コード) {
        if (A_06.equals(厚労省IF識別コード) || A_09.equals(厚労省IF識別コード)
                || B_09.equals(厚労省IF識別コード)) {
            if (連番_8 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set短期入所生活介護_ショートステイ(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            } else if (連番_9 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set短期入所療養介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            } else if (連番_10 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set特定施設入居者生活介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            } else if (連番_12 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set特定福祉用具販売(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            } else if (連番_13 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set夜間対応型訪問介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            } else if (連番_14 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set認知症対応型通所介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            } else if (連番_15 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set小規模多機能型居宅介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            } else if (連番_16 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set認知症対応型共同生活介護_グループホーム(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            } else if (連番_17 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set地域密着型特定施設入居者生活介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            } else if (連番_18 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set地域密着型介護老人福祉施設入所者生活介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set予防給付サービス_A_99_A_02(IchijihanteikekkahyoItem item, ItiziHanteiEntity itiziHanteiEntity) {
        if (連番_8 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set福祉用具貸与(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_9 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set短期入所生活介護_ショートステイ(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_10 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set短期入所療養介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_12 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set特定施設入居者生活介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_11 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防認知症対応型共同生活介護_グループホーム(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        return item;
    }

    private IchijihanteikekkahyoItem set介護給付サービス(IchijihanteikekkahyoItem item, RString dbt5207厚労省IF識別コード,
            RString 厚労省IF識別コード, ItiziHanteiEntity entity, List<ItiziHanteiEntity> itiziHanteiEntityList) {
        for (ItiziHanteiEntity itiziHanteiEntity : itiziHanteiEntityList) {
            if (dbt5207厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5101_koroshoIfShikibetsuCode().value())
                    && entity.getDbt5202_serviceKubunCode().equals(itiziHanteiEntity.getDbt5202_serviceKubunCode())) {
                if (連番_1 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防訪問介護_ﾎｰﾑﾍﾙﾌﾟ_訪問型ｻｰﾋﾞｽ(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (連番_2 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防訪問入浴介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (連番_3 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防訪問看護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (連番_4 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防訪問リハビリテーション(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (連番_5 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防居宅療養管理指導(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (連番_6 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防通所介護_ﾃﾞｲｻｰﾋﾞｽ_通所型ｻｰﾋﾞｽ(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (連番_7 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防通所リハビリテーション(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                } else if (A_99.equals(厚労省IF識別コード) || A_02.equals(厚労省IF識別コード)) {
                    item = set介護給付サービス_A_99_A_02(item, itiziHanteiEntity);
                } else if (A_06.equals(厚労省IF識別コード) || A_09.equals(厚労省IF識別コード)
                        || B_09.equals(厚労省IF識別コード)) {
                    set介護給付サービス_A_06_A_09_B_09(item, itiziHanteiEntity);
                }
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set介護給付サービス_A_06_A_09_B_09(IchijihanteikekkahyoItem item, ItiziHanteiEntity itiziHanteiEntity) {
        if (連番_8 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防短期入所生活介護_ショートステイ(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_9 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防短期入所療養介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_10 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防特定施設入居者生活介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_12 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set特定介護予防福祉用具販売(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_14 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防認知症対応型通所介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_15 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防小規模多機能型居宅介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_16 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防認知症対応型共同生活介護_グループホーム(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        return item;
    }

    private IchijihanteikekkahyoItem set介護給付サービス_A_99_A_02(IchijihanteikekkahyoItem item, ItiziHanteiEntity itiziHanteiEntity) {
        if (連番_8 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防福祉用具貸与(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_9 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防短期入所生活介護_ショートステイ(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_10 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防短期入所療養介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_12 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防特定施設入居者生活介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        } else if (連番_11 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防認知症対応型共同生活介護_グループホーム(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        return item;
    }

    private RString getカテーテル特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.カテーテル.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.カテーテル.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.カテーテル.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.カテーテル.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString getじょくそうの処置特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.じょくそうの処置.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.じょくそうの処置.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.じょくそうの処置.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.じょくそうの処置.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString getモニター測定特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.モニター測定.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.モニター測定.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.モニター測定.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.モニター測定.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get気管切開の処置特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.気管切開の処置.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.気管切開の処置.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.気管切開.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.気管切開.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get簡単な調理特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.簡単な調理.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.簡単な調理.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get買い物特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.買い物.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.買い物.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get集団への不適応特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.集団への不適応.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.集団への不適応.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get日常の意思決定特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.意思決定.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.意思決定.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.日常の意思決定.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.日常の意思決定.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get金銭の管理特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.金銭の管理.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.金銭の管理.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.金銭の管理.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.金銭の管理.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get薬の内服特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.薬の内服.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.薬の内服.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.薬の内服.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.薬の内服.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get話がまとまらない特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.話がまとまらない.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.話がまとまらない.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get自分勝手に行動する特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.自分勝手に行動する.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.自分勝手に行動する.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get独り言_独り笑い特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.独り言独り笑い.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.独り言独り笑い.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString getひどい物忘れ特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.ひどい物忘れ.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.ひどい物忘れ.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.ひどい物忘れ.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.ひどい物忘れ.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get物や衣類を壊す特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.物や衣類を壊す.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.物や衣類を壊す.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.物や衣類を壊す.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.物や衣類を壊す.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get収集癖特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.収集癖.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.収集癖.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.収集癖.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.収集癖.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get一人で出たがる特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.一人で出たがる.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.一人で出たがる.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.一人で出たがる.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.一人で出たがる.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get落ち着きなし特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.落ち着きなし.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.落ち着きなし.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.落ち着きなし.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.落ち着きなし.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get介護に抵抗特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.介護に抵抗.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.介護に抵抗.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.介護に抵抗.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.介護に抵抗.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get大声を出す特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.大声をだす.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.大声をだす.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.大声を出す.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.大声を出す.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get同じ話をする特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.同じ話をする.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.同じ話をする.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.同じ話をする.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.同じ話をする.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get昼夜逆転特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.昼夜逆転.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.昼夜逆転.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.昼夜逆転.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.昼夜逆転.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get感情が不安定特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.感情が不安定.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.感情が不安定.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.感情が不安定.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.感情が不安定.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get作話特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.作話.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.作話.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.作話.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.作話.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get被害的特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.被害的.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.被害的.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.被害的.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.被害的.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get外出して戻れない特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.外出して戻れない.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.外出して戻れない.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.外出頻度.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.外出頻度.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get徘徊特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.常時の徘徊.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.常時の徘徊.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.徘徊.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.徘徊.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get場所の理解特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.自分がいる場所の理解.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.自分がいる場所の理解.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.場所の理解.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.場所の理解.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get今の季節を理解特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.今の季節を理解.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.今の季節を理解.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.今の季節を理解する.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.今の季節を理解する.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get自分の名前をいう特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.自分の名前をいう.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.自分の名前をいう.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.自分の名前を言う.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.自分の名前を言う.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get短期記憶特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.短期記憶.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.短期記憶.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.短期記憶.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.短期記憶.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get生年月日をいう特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.生年月日や年齢をいう.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.生年月日や年齢をいう.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.生年月日や年齢を言う.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.生年月日や年齢を言う.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get毎日の日課を理解特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.毎日の日課を理解.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.毎日の日課を理解.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.毎日の日課を理解.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.毎日の日課を理解.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get意思の伝達特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.意思の伝達.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.意思の伝達.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.意思の伝達.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.意思の伝達.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get外出頻度特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.外出頻度.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.外出頻度.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.外出頻度.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString getズボン等の着脱特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.ズボン等の着脱.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.ズボン等の着脱.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.ズボン等の着脱.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.ズボン等の着脱.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get口腔清潔特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.口腔清潔.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.口腔清潔.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.口腔清潔.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.口腔清潔.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString getコード(RString 厚労省IF識別コード, int コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping99A(new RString(コード));
        } else if (A_02.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping02A(new RString(コード));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping06A(new RString(コード));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping09A(new RString(コード));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping09B(new RString(コード));
        }
        return RString.EMPTY;
    }

    private RString getNinteichosaKomokuMapping99A(RString コード) {
        try {
            return NinteichosaKomokuMapping99A.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomokuMapping02A(RString コード) {
        try {
            return NinteichosaKomokuMapping02A.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomokuMapping06A(RString コード) {
        try {
            return NinteichosaKomokuMapping06A.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomokuMapping09A(RString コード) {
        try {
            return NinteichosaKomokuMapping09A.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomokuMapping09B(RString コード) {
        try {
            return NinteichosaKomokuMapping09B.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomoku02A(RString 名称) {
        for (NinteichosaKomoku02A komoku : NinteichosaKomoku02A.values()) {
            if (komoku.get名称().equals(名称)) {
                return komoku.get調査特記事項番序();
            }
        }
        return RString.EMPTY;
    }

    private RString getNinteichosaKomoku06A(RString 名称) {
        for (NinteichosaKomoku06A komoku : NinteichosaKomoku06A.values()) {
            if (komoku.get名称().equals(名称)) {
                return komoku.get調査特記事項番序();
            }
        }
        return RString.EMPTY;
    }

    private RString getNinteichosaKomoku09A(RString 名称) {
        for (NinteichosaKomoku09A komoku : NinteichosaKomoku09A.values()) {
            if (komoku.get名称().equals(名称)) {
                return komoku.get調査特記事項番序();
            }
        }
        return RString.EMPTY;
    }

    private RString getNinteichosaKomoku09B(RString 名称) {
        for (NinteichosaKomoku09B komoku : NinteichosaKomoku09B.values()) {
            if (komoku.get名称().equals(名称)) {
                return komoku.get調査特記事項番序();
            }
        }
        return RString.EMPTY;
    }

    private RString get特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報, RString 名称) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(getNinteichosaKomoku02A(名称), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(getNinteichosaKomoku06A(名称), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(getNinteichosaKomoku09A(名称), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(getNinteichosaKomoku09B(名称), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get拘縮の有無特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.間接の動く範囲の制限の有無.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.間接の動く範囲の制限の有無.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.拘縮の有無.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.拘縮の有無.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get麻痺特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.麻痺等の有無.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.麻痺等の有無.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.麻痺等の有無.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.麻痺等の有無.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get認知症高齢者自立度_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.認知症高齢者自立度.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.認知症高齢者自立度.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.認知症高齢者自立度.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.認知症高齢者自立度.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get障害高齢者自立度_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.障害高齢者自立度.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.障害高齢者自立度.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.障害高齢者自立度.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.障害高齢者自立度.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private boolean is特記事項(RString 調査特記事項番号, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        List<RString> 特記事項番号 = new ArrayList<>();
        RString 特記事項符号有無 = DbBusinessConfig.get(ConfigNameDBE.特記事項符号印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        for (NinteichosahyoTokkijikoEntity entity : 特記事項情報) {
            特記事項番号.add(new RString(entity.getRokkijikoRemban()));
        }
        return 印字する.equals(特記事項符号有無) && 特記事項番号.contains(調査特記事項番号);
    }

    private RString get特記事項(boolean is特記事項) {
        if (is特記事項) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    private RString 前々回認定有効期間(int 二次判定認定有効期間) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(二次判定認定有効期間)
                .append(月間);
        return builder.toRString();
    }

    private RString 前々回認定有効期間(FlexibleDate 前回認定有効期間_開始, FlexibleDate 前回認定有効期間_終了) {
        RStringBuilder builder = new RStringBuilder();
        if (前回認定有効期間_開始 != null && !前回認定有効期間_開始.isEmpty()
                && 前回認定有効期間_終了 != null && !前回認定有効期間_終了.isEmpty()) {
            builder.append(前回認定有効期間_終了.getMonthValue() - 前回認定有効期間_開始.getMonthValue() + 1)
                    .append(月間);
            return builder.toRString();
        }
        return RString.EMPTY;
    }

    private RString パターン17(FlexibleDate 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return RString.EMPTY;
        }
        return 項目.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.SLASH)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString パターン16(FlexibleDate 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return RString.EMPTY;
        }
        return 項目.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private IchijihanteikekkahyoItem コード転換(IchijihanteikekkahyoItem item, ItiziHanteiEntity entity) {
        item.set申請区分(entity.getDbt5101_ninteiKubunCode() == null || entity.getDbt5101_ninteiKubunCode().isEmpty() ? RString.EMPTY
                : NinteiShinseiShinseijiKubunCode.toValue(entity.getDbt5101_ninteiKubunCode().value()).get名称());
        item.set性別(entity.getDbt5101_seibetsu() == null || entity.getDbt5101_seibetsu().isEmpty()
                ? RString.EMPTY : Seibetsu.toValue(entity.getDbt5101_seibetsu().value()).get名称());
        item.set前回要介護度(entity.getDbt5101_zenYokaigoKubunCode() == null || entity.getDbt5101_zenYokaigoKubunCode().isEmpty() ? RString.EMPTY
                : YokaigoJotaiKubun09.toValue(entity.getDbt5101_zenYokaigoKubunCode().value()).get名称());
        item.set前回状態像(entity.getDbt5101_zenYokaigoKubunCode() == null || entity.getDbt5101_zenYokaigoKubunCode().isEmpty() ? RString.EMPTY
                : YokaigoJotaiKubun09.toValue(entity.getDbt5101_zenYokaigoKubunCode().value()).get名称());
        item.set一次判定結果(entity.getDbt5116_ichijiHanteiKekkaCode() == null || entity.getDbt5116_ichijiHanteiKekkaCode().isEmpty() ? RString.EMPTY
                : IchijiHanteiKekkaCode09.toValue(entity.getDbt5116_ichijiHanteiKekkaCode().value()).get名称());
        item.set障害高齢者自立度(entity.getDbT5203_shogaiCode() == null || entity.getDbT5203_shogaiCode().isEmpty() ? RString.EMPTY
                : ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.getDbT5203_shogaiCode().value()).get名称());
        item.set認知症高齢者自立度(entity.getDbT5203_ninchishoCode() == null || entity.getDbT5203_ninchishoCode().isEmpty() ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.getDbT5203_ninchishoCode().value()).get名称());
        item = setコード転換(item, entity);
        return item;
    }

    private IchijihanteikekkahyoItem setコード転換(IchijihanteikekkahyoItem item, ItiziHanteiEntity entity) {
        item.set認定調査結果認知症高齢者自立度(
                entity.getDbT5203_ninchishoCode() == null || entity.getDbT5203_ninchishoCode().isEmpty() ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.getDbT5203_ninchishoCode().value()).get名称());
        item.set意見書認知症高齢者自立度(entity.getDbT5203_ninchishoCode() == null || entity.getDbT5203_ninchishoCode().isEmpty() ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.getDbT5203_ninchishoCode().value()).get名称());
        item.set状態の安定性(entity.getDbt5116_jotaiAnteiseiCode() == null || entity.getDbt5116_jotaiAnteiseiCode().isEmpty() ? RString.EMPTY
                : JotaiAnteiseiCode.toValue(entity.getDbt5116_jotaiAnteiseiCode().value()).get名称());
        item.set給付区分(entity.getDbt5116_suiteiKyufuKubunCode() == null || entity.getDbt5116_suiteiKyufuKubunCode().isEmpty() ? RString.EMPTY
                : SuiteiKyufuKubunCode.toValue(entity.getDbt5116_suiteiKyufuKubunCode().value()).get名称());
        item.set現在のサービス利用状況(entity.getDbt5202_serviceKubunCode() == null || entity.getDbt5202_serviceKubunCode().isEmpty() ? RString.EMPTY
                : ServiceKubunCode.toValue(entity.getDbt5202_serviceKubunCode().value()).get名称());
        if (HihokenshaKubunCode.第１号被保険者.getコード().equals(entity.getDbt5101_hihokenshaKubunCode())) {
            item.set特定疾病名(RString.EMPTY);
        } else if (HihokenshaKubunCode.第２号被保険者.getコード().equals(entity.getDbt5101_hihokenshaKubunCode())) {
            item.set特定疾病名(entity.getDbt5101_nigoTokuteiShippeiCode() == null || entity.getDbt5101_nigoTokuteiShippeiCode().isEmpty() ? RString.EMPTY
                    : TokuteiShippei.toValue(entity.getDbt5101_nigoTokuteiShippeiCode().value()).get名称());
        }
        return item;
    }
}
