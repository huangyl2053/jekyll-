/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt32003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.jikokisanbikanri.JikoKisanbiKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32003.ShunoJokyoHaakuProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.KibetsuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.ShunoJokyoHaakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoJokyoHaakuTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 収納状況把握情報の取得_Process処理クラスです．
 *
 * @reamsid_L DBD-3610-050 x_lilh
 */
public class ShunoJokyoHaakuProcess extends BatchProcessBase<ShunoJokyoHaakuEntity> {

    private ShunoJokyoHaakuProcessParameter parameter;
    private FlexibleYear 日付関連_調定年度;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugengakulist."
                    + "IShunoTainoJokyoHaakuMapper.get対象者把握情報");
    private List<RString> psmTotalShunyu;
    private static final RString 普通徴収 = new RString("普通徴収");
    private static final RString 特別徴収 = new RString("特別徴収");
    private static final RString LEFT_FORMAT = new RString("'{");
    private static final RString RIGHT_FORMAT = new RString("}'");
    private static final RString MIDDLE_FORMAT = new RString(",");
    private static final int INT_9 = 9;

    @Override
    protected void initialize() {
        RString 日付関連_調定年度R = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        日付関連_調定年度 = new FlexibleYear(日付関連_調定年度R).minusYear(INT_9);
        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 介護保険料_普通徴収 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        IShunoKamoku 介護保険料_特別徴収 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
        psmTotalShunyu = new ArrayList<>();
        if (介護保険料_普通徴収 != null && !RString.isNullOrEmpty(介護保険料_普通徴収.get表示用コードwithハイフン())) {
            psmTotalShunyu.add(介護保険料_普通徴収.get表示用コードwithハイフン());
        }
        if (介護保険料_特別徴収 != null && !RString.isNullOrEmpty(介護保険料_特別徴収.get表示用コードwithハイフン())) {
            psmTotalShunyu.add(介護保険料_特別徴収.get表示用コードwithハイフン());
        }

        RStringBuilder rStringBuilder = new RStringBuilder();
        rStringBuilder.append(LEFT_FORMAT);
        if (!psmTotalShunyu.isEmpty()) {
            for (int i = 0; i < psmTotalShunyu.size(); i++) {
                rStringBuilder.append(psmTotalShunyu.get(i) == null ? RString.EMPTY : psmTotalShunyu.get(i));
                if (i != psmTotalShunyu.size() - 1) {
                    rStringBuilder.append(MIDDLE_FORMAT);
                }
            }
        }
        rStringBuilder.append(RIGHT_FORMAT);
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        key.set基準日(parameter.get基準日());
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());

        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toShunoJokyoHaakuMybatisParameter(parameter.get基準日(),
                日付関連_調定年度, psmShikibetsuTaisho, psmTotalShunyu));
    }
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShunoJokyoHaakuTempTableEntity.class)
                .tempTableName(ShunoJokyoHaakuTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShunoJokyoHaakuEntity shunoJokyoEntity) {
        ShunoJokyoHaakuTempTableEntity entity = データ編集(shunoJokyoEntity);
        if (entity != null) {
            tmpTableWriter.insert(entity);
        }
    }

    private ShunoJokyoHaakuTempTableEntity データ編集(ShunoJokyoHaakuEntity shunoJokyoEntity) {

        HihokenshaNo 被保険者番号 = shunoJokyoEntity.get資格情報Entity().getHihokenshaNo();
        ShikibetsuCode 識別コード = shunoJokyoEntity.get宛名Entity().getShikibetsuCode();
        RString 被保険者氏名カナ = shunoJokyoEntity.get宛名Entity().getKanaName();
        AtenaMeisho 被保険者氏名 = shunoJokyoEntity.get宛名Entity().getKanjiShimei();
        SetaiCode 世帯番号 = shunoJokyoEntity.get宛名Entity().getSetaiCode();
        GyoseikuCode 行政区ｺｰﾄﾞ = shunoJokyoEntity.get宛名Entity().getGyoseikuCode();
        RString 行政区 = shunoJokyoEntity.get宛名Entity().getGyoseikuName();
        ZenkokuJushoCode 住所コード = shunoJokyoEntity.get宛名Entity().getZenkokuJushoCode();
        YubinNo 郵便番号 = shunoJokyoEntity.get宛名Entity().getYubinNo();
        AtenaJusho 住所 = shunoJokyoEntity.get宛名Entity().getJusho();
        FlexibleDate 資格取得日 = shunoJokyoEntity.get資格情報Entity().getShikakuShutokuYMD();
        FlexibleDate 資格喪失日 = shunoJokyoEntity.get資格情報Entity().getShikakuSoshitsuYMD();
        RString 喪失事由 = shunoJokyoEntity.get資格情報Entity().getShikakuSoshitsuJiyuCode();
//        RString 資格区分 = shunoJokyoEntity.get資格情報Entity().getShikaku  QA待ち
        RString 住所地特例フラグ = shunoJokyoEntity.get資格情報Entity().getJushochiTokureiFlag();

        Code 厚労省IF識別コード = Code.EMPTY;
        Code 要介護状態区分コード = Code.EMPTY;
        FlexibleDate 認定有効期間開始年月日 = FlexibleDate.EMPTY;
        FlexibleDate 認定有効期間終了年月日 = FlexibleDate.EMPTY;
        FlexibleDate 認定日 = FlexibleDate.EMPTY;
        FlexibleDate 申請日 = FlexibleDate.EMPTY;
        if (shunoJokyoEntity.get認定情報() != null) {
            厚労省IF識別コード = shunoJokyoEntity.get認定情報().get要介護認定申請Entity().getKoroshoIfShikibetsuCode();
            要介護状態区分コード = shunoJokyoEntity.get認定情報().get受給者Entity().getYokaigoJotaiKubunCode();
            認定有効期間開始年月日 = shunoJokyoEntity.get認定情報().get要介護認定申請Entity().getZenkaiYukoKikanStart();
            認定有効期間終了年月日 = shunoJokyoEntity.get認定情報().get要介護認定申請Entity().getZenkaiYukoKikanEnd();
            認定日 = shunoJokyoEntity.get認定情報().get受給者Entity().getNinteiYMD();
            申請日 = shunoJokyoEntity.get認定情報().get要介護認定申請Entity().getNinteiShinseiYMD();
        }

        boolean 申請中フラグ = false;
        if (shunoJokyoEntity.get申請中被保険者() != null) {
            申請中フラグ = true;
        }
        boolean 生保フラグ = false;
        if (shunoJokyoEntity.get生保情報Entity().getJukyuKaishiYMD() != null && !shunoJokyoEntity.get生保情報Entity().getJukyuKaishiYMD().isEmpty()) {
            生保フラグ = true;
        }

        FlexibleYear 賦課年度 = shunoJokyoEntity.get収納情報().get賦課Entity().getFukaNendo();
        FlexibleYear 調定年度 = shunoJokyoEntity.get収納情報().get賦課Entity().getChoteiNendo();

        List<KibetsuJohoEntity> 期別情報List = shunoJokyoEntity.get収納情報().get期別();
        if (期別情報List == null) {
            期別情報List = new ArrayList<>();
        }

        ShunoJokyoHaakuTempTableEntity tmpTblEntity;
        for (KibetsuJohoEntity 期別 : 期別情報List) {
            tmpTblEntity = new ShunoJokyoHaakuTempTableEntity();

            UrT0705ChoteiKyotsuEntity 調定共通Entity = 期別.get調定関連().get調定共通Entity();
            if (調定共通Entity == null) {
                調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            }

            int 期 = 期別.get期別Entity().getKi();
            Decimal 調定額 = 調定共通Entity.getChoteigaku();
            Decimal 収入額 = 期別.get調定関連().get収入().get最新収入Entity().getShunyugaku();  // QA #101563
            Decimal 未納額 = 調定額.subtract(収入額);
            RDate 納期限 = 調定共通Entity.getNokigenYMD();

            RString 時効起算事由 = RString.EMPTY;
            FlexibleDate 仮の時効起算日 = FlexibleDate.EMPTY;
            FlexibleDate 時効起算年月日 = 期別.get時効起算日管理Entity().getJikoKisanYMD();
            RDate 納期限の翌日 = 調定共通Entity.getNokigenYMD().plusDay(1);
            RDate 督促状発行年月日 = 期別.get調定関連().getCaT1018_督促状発行履歴Entity().getTokusokujoHakkoYMD();
            if (時効起算年月日 != null && !時効起算年月日.isEmpty()) {
                仮の時効起算日 = 時効起算年月日;
                時効起算事由 = 期別.get時効起算日管理Entity().getJikoKisanYMDKubun();

            } else if (督促状発行年月日 != null) {
                仮の時効起算日 = new FlexibleDate(督促状発行年月日.toDateString());
                時効起算事由 = JikoKisanbiKubun.督促状発行日.getコード();

            } else if (納期限の翌日 != null) {
                仮の時効起算日 = new FlexibleDate(納期限の翌日.toDateString());
                時効起算事由 = JikoKisanbiKubun.納期限翌日.getコード();
            }

            // 収入の取得結果を、以下の要素を持つリストとする。 DBDEnum.時効起算日区分. 収入日 QA#102231
            FlexibleDate 時効起算日 = 仮の時効起算日;
            if (時効起算日.equals(FlexibleDate.EMPTY)) {
                時効起算事由 = JikoKisanbiKubun.不明_調定無し.getコード();
            }

            RString 未納完納区分 = RString.EMPTY;
            if (parameter.get基準日().isBefore(new FlexibleDate(納期限.toDateString()))) {
                未納完納区分 = MinoKannoKubun.未来納期.getコード();
            } else if (未納額.equals(Decimal.ZERO)) {
                未納完納区分 = MinoKannoKubun.完納.getコード();
            } else if (未納額.compareTo(Decimal.ZERO) > 0) {
                未納完納区分 = MinoKannoKubun.未納あり.getコード();
            } else if (未納額.compareTo(Decimal.ZERO) < 0) {
                未納完納区分 = MinoKannoKubun.過納.getコード();
            } else if (時効起算日.isEmpty() || 調定額.compareTo(Decimal.ZERO) == 0) {
                未納完納区分 = MinoKannoKubun._0円.getコード();
            }

            RString 時効区分 = RString.EMPTY;
            if (MinoKannoKubun.未納あり.getコード().equals(未納完納区分)) {
                if (parameter.get基準日().isBefore(時効起算日.plusYear(2))) {
                    時効区分 = JikoKubun.時効未到来.getコード();
                } else if (時効起算日.plusYear(2).isBeforeOrEquals(parameter.get基準日())) {
                    時効区分 = JikoKubun.時効到来.getコード();
                }
            } else {
                時効区分 = JikoKubun.空.getコード();
            }

            RString 特徴_普徴区分 = 期別.get期別Entity().getChoshuHouhou();
            TsuchishoNo 通知書番号 = 期別.get期別Entity().getTsuchishoNo();
            RDate 督促状発行日 = 期別.get調定関連().getCaT1018_督促状発行履歴Entity().getTokusokujoHakkoYMD();

            tmpTblEntity.setHihokenshaNo(被保険者番号);
            tmpTblEntity.setShikibetsuCode(識別コード);
            tmpTblEntity.setHihokenshaShimeiKana(被保険者氏名カナ);
            tmpTblEntity.setHihokenshaShimei(被保険者氏名);
            tmpTblEntity.setSetaiCode(世帯番号);
            tmpTblEntity.setGyoseikuCode(行政区ｺｰﾄﾞ);
            tmpTblEntity.setGyoseikuName(行政区);
            tmpTblEntity.setJushoCode(住所コード);
            tmpTblEntity.setYubinNo(郵便番号);
            tmpTblEntity.setJusho(住所);
            tmpTblEntity.setShikakuShutokuYMD(資格取得日);
            tmpTblEntity.setShikakuSoshitsuYMD(資格喪失日);
            tmpTblEntity.setShikakuSoshitsuJiyuCode(喪失事由);
//    tmpTblEntity.setShikakuKubunCode();    QA#102231
            tmpTblEntity.setKoikinaiJushochiTokureiFlag(住所地特例フラグ);
            tmpTblEntity.setSeihoFlag(生保フラグ);
            tmpTblEntity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
            tmpTblEntity.setYokaigoJotaiKubunCode(要介護状態区分コード);
            tmpTblEntity.setNinteiYukoKikanKaishiYMD(認定有効期間開始年月日);
            tmpTblEntity.setNinteiYukoKikanShuryoYMD(認定有効期間終了年月日);
            tmpTblEntity.setNinteiYMD(認定日);
            tmpTblEntity.setShiseityuFlag(申請中フラグ);
            tmpTblEntity.setJukyuShinseiYMD(申請日);
            tmpTblEntity.setChoteiNendo(調定年度);
            tmpTblEntity.setFukaNendo(賦課年度);
            tmpTblEntity.setTokucho_FuchoKubun(特徴_普徴区分);
            tmpTblEntity.setTsuchishoNo(通知書番号);
            tmpTblEntity.setKibetsu(new RString(期));
            tmpTblEntity.setChoteigaku(調定額);
            tmpTblEntity.setShunyugaku(収入額);
            tmpTblEntity.setMinogaku(未納額);
            tmpTblEntity.setNokigen(納期限);
//            tmpTblEntity.setShunyuYMD;  QA#102231
            tmpTblEntity.setTokusokujoHakkoYMD(督促状発行日);
            tmpTblEntity.setJikoKisanYMD(時効起算日);
            tmpTblEntity.setJikoKisanJiyu(時効起算事由);
            tmpTblEntity.setMinoKannoKubun(未納完納区分);
            tmpTblEntity.setJikoKubun(時効区分);

            return tmpTblEntity;
        }
        return null;
    }

}
