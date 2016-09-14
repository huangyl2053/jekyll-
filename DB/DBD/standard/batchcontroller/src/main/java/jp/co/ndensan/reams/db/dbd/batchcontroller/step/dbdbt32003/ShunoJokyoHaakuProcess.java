/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt32003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TokuchoFuchoKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32003.ShunoJokyoHaakuProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.ShunoJokyoHaakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoJokyoHaakuTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
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
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

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

//        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
//        psmTotalShunyu = sut.get更新権限科目コード(ControlDataHolder.getUserId());
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
    protected void process(ShunoJokyoHaakuEntity t) {
        tmpTableWriter.insert(create重複処理(t));
    }

    //
//    private List<RString> get検索用科目リスト() {
//        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
//        IShunoKamoku 介護保険料_普通徴収 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
//        IShunoKamoku 介護保険料_特別徴収 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
//        kamokuList = new ArrayList<>();
//        kamokuList.add(介護保険料_普通徴収.get表示用コードwithハイフン());
//        kamokuList.add(介護保険料_特別徴収.get表示用コードwithハイフン());
//        return kamokuList;
//    }
    private ShunoJokyoHaakuTempTableEntity create重複処理(ShunoJokyoHaakuEntity shun) {
        ShunoJokyoHaakuTempTableEntity data = new ShunoJokyoHaakuTempTableEntity();

        IKojin kojin = ShikibetsuTaishoFactory.createKojin(shun.getFindShikibetsuTaishoEntity());
        //
        data.setHihokenshaNo(shun.getShunoJohoEntity().get(0).getFukaEntity().getHihokenshaNo());
        data.setShikibetsuCode(kojin.get識別コード());
        data.setHihokenshaShimeiKana(kojin.get名称().getKana().getColumnValue());
        data.setHihokenshaShimei(kojin.get名称().getName());
        data.setSetaiCode(kojin.get世帯コード());
        data.setGyoseikuCode(kojin.get行政区画().getGyoseiku().getコード());
        data.setGyoseikuName(kojin.get行政区画().getGyoseiku().get名称());
        data.setJushoCode(kojin.get住所().get全国住所コード());
        data.setYubinNo(kojin.get住所().get郵便番号().getYubinNo());
        data.setJusho(kojin.get住所().get住所());
        data.setShikakuShutokuYMD(shun.getHihokenshaDaichoEntity().getShikakuShutokuYMD());
        data.setShikakuSoshitsuYMD(shun.getHihokenshaDaichoEntity().getShikakuSoshitsuYMD());
        data.setShikakuSoshitsuJiyuCode(shun.getHihokenshaDaichoEntity().getShikakuHenkoJiyuCode());
        data.setHihokennshaKubunCode(shun.getHihokenshaDaichoEntity().getHihokennshaKubunCode());
        data.setKoikinaiJushochiTokureiFlag(shun.getHihokenshaDaichoEntity().getJushochiTokureiFlag());
        if (shun.getSeikatsuHogoJukyushaEntity().getJukyuKaishiYMD() != null
                || !shun.getSeikatsuHogoJukyushaEntity().getJukyuKaishiYMD().isEmpty()) {
            data.setSeihoFlag(true);
        } else {
            data.setSeihoFlag(false);
        }
        data.setKoroshoIfShikibetsuCode(shun.getNinteiJohoEntity().getNinteiShinseiJohoEntity().getKoroshoIfShikibetsuCode());
        data.setYokaigoJotaiKubunCode(shun.getNinteiJohoEntity().getJukyushaDaichoEntity().getYokaigoJotaiKubunCode());
        data.setNinteiYukoKikanKaishiYMD(shun.getNinteiJohoEntity().getJukyushaDaichoEntity().getNinteiYukoKikanKaishiYMD());
        data.setNinteiYukoKikanShuryoYMD(shun.getNinteiJohoEntity().getJukyushaDaichoEntity().getNinteiYukoKikanShuryoYMD());
        data.setNinteiYMD(shun.getNinteiJohoEntity().getJukyushaDaichoEntity().getNinteiYMD());
        //22   meixie
        data.setShiseityuFlag(true);
        data.setJukyuShinseiYMD(shun.getNinteiJohoEntity().getJukyushaDaichoEntity().getJukyuShinseiYMD());
        data.setChoteiNendo(shun.getShunoJohoEntity().get(0).getFukaEntity().getChoteiNendo());
        data.setFukaNendo(shun.getShunoJohoEntity().get(0).getFukaEntity().getFukaNendo());
//        data.setTokucho_FuchoKubun(set特徴普徴区分(shun.getShunoJohoEntity().getJikoKisambiKanri().getTokucho_FuchoKubun()));
//        data.setTsuchishoNo(shun.getShunoJohoEntity().getJikoKisambiKanri().getTsuchishoNo());
//        data.setKibetsu(shun.getShunoJohoEntity().getJikoKisambiKanri().getShuno_Ki_Tsuki());
        //Decimal 調定額 = shun.getShunoJohoEntity().get(0).getKibetsuJohoEntity().getChoteiKyotsuEntity().getChoteigaku();
        //Decimal 収入額 = shun.getShunoJohoEntity().get(0).getFukaEntity().getNenkinShunyuGaku();
//        Decimal 未納額;
//        if (収入額 == Decimal.ZERO) {
//            未納額 = new Decimal("0");
//        } else {
//            未納額 = 調定額.subtract(収入額);
//        }
//        data.setChoteigaku(調定額);
//        data.setShunyugaku(未納額);
        //data.setShunyuYMD(RDate.MIN);//32収納情報.収入日    QA
        data.setTokusokujoHakkoYMD(shun.getTokusokuHakkoRirekiEntity().getTokusokujoHakkoYMD());
        return data;
    }

    private RString set特徴普徴区分(RString code) {
        if (TokuchoFuchoKubun.普通徴収.getコード().equals(code)) {
            return 普通徴収;
        } else if (TokuchoFuchoKubun.特別徴収.getコード().equals(code)) {
            return 特別徴収;
        } else {
            return RString.EMPTY;
        }
    }
    //    private void adasd(ShunoJokyoHaakuEntity shun) {
//        ShunoJokyoHaakuTempTableEntity data = new ShunoJokyoHaakuTempTableEntity();
//        data.setFukaNendo(shun.getShunoJohoEntity().getFukaJohoEntity().getFukaEntity().getFukaNendo());
//        data.setChoteiNendo(shun.getShunoJohoEntity().getFukaJohoEntity().getFukaEntity().getChoteiNendo());
//        // data.setKibetsu(shun.getShunoJohoEntity().getFukaJohoEntity().getKibetsuJohoEntity().getKibetsuEntity().getKi());  期
//        Decimal 調定額 = shun.getShunoJohoEntity().getFukaJohoEntity().getKibetsuJohoEntity().getChoteiKyotsuEntity().getChoteigaku();
//        Decimal 収入額 = shun.getShunoJohoEntity().getFukaJohoEntity().getFukaEntity().getNenkinShunyuGaku();
//        Decimal 未納額;
//        if (収入額 == Decimal.ZERO) {
//            未納額 = new Decimal("0");
//        } else {
//            未納額 = 調定額.subtract(収入額);
//        }
//
//        FlexibleDate 時効起算日 = null;//34
//        FlexibleDate 収入年月日 = null;//QA
//
//        //時効起算事由
//        if (収入年月日 == 時効起算日) {
//            JikoKisanbiKubun jikoKisanJiyu = JikoKisanbiKubun.収入日;
//        } else if (時効起算日 == shun.getShunoJohoEntity().getJikoKisambiKanri().getJikoKisanYMD()) {
//            RString jikoKisanJiyu = shun.getShunoJohoEntity().getJikoKisambiKanri().getJikoKisanYMDKubun();
//        } else if (時効起算日.equals(shun.getTokusokuHakkoRirekiEntity().getTokusokujoHakkoYMD().toFlexibleDate())) {
//            JikoKisanbiKubun jikoKisanJiyu = JikoKisanbiKubun.督促状発行日;
//        } //QA
//        else if (時効起算日.isEmpty()) {
//            JikoKisanbiKubun jikoKisanJiyu = JikoKisanbiKubun.不明_調定無し;
//        }
//        //未納完納区分
//        if (shun.getShunoJohoEntity().getFukaJohoEntity().getKibetsuJohoEntity().getChoteiKyotsuEntity().getNokigenYMD()
//                .isBefore(parameter.get基準日().toRDate())) {
//            RString 未納完納区分 = MinoKannoKubun.未来納期.get名称();
//        } else if (未納額 == Decimal.ZERO) {
//            RString 未納完納区分 = MinoKannoKubun.完納.get名称();
//        } else if (未納額.compareTo(Decimal.ZERO) > 0) {
//            RString 未納完納区分 = MinoKannoKubun.未納あり.get名称();
//            //時効区分
//            if (時効起算日.plusYear(2).compareTo(parameter.get基準日()) > 0) {
//                JikoKubun jikoKubun = JikoKubun.時効未到来;
//            } else if (時効起算日.plusYear(2).compareTo(parameter.get基準日()) <= 0) {
//                JikoKubun jikoKubun = JikoKubun.時効到来;
//            } else {
//                JikoKubun jikoKubun = JikoKubun.空;
//            }
//
//        } else if (未納額.compareTo(Decimal.ZERO) < 0) {
//            MinoKannoKubun 未納完納区分 = MinoKannoKubun.過納;
//        }
////２．４　資格情報の編集
//
//    }
}
