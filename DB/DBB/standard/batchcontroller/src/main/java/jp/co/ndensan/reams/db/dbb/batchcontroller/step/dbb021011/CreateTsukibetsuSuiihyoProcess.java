/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.GennendoDate;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.HihokenshaDaichoPsm;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 月別推移表作成帳票用Processクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
public class CreateTsukibetsuSuiihyoProcess extends BatchProcessBase<HihokenshaDaichoPsm> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper.get被保険者台帳管理と宛名のデータ");
    private static final RString 普通徴収 = new RString("2");
    private static final RString 特別徴収 = new RString("1");
    private static final RString 四月 = new RString("04");
    private static final RString 五月 = new RString("05");
    private static final RString 六月 = new RString("06");
    private static final RString 七月 = new RString("07");
    private static final RString 八月 = new RString("08");
    private static final RString 九月 = new RString("09");
    private static final RString 十月 = new RString("10");
    private static final RString 十一月 = new RString("11");
    private static final RString 十二月 = new RString("12");
    private static final RString 一月 = new RString("01");
    private static final RString 二月 = new RString("02");
    private static final RString 三月 = new RString("03");
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final RString TABLE_資格状況一時テーブル = new RString("TmpSikakuJyoukyou_Ichi");
    private static final RString TABLE_介護情報一時テーブル = new RString("TmpKayigoJyoho_Ichi");
    private static final RString TABLE_減免介護情報一時テーブル = new RString("TmpGemmenKayigoJyoho_Ichi");
    private List<HihokenshaDaichoPsm> hihokenshaDaichoPsmList;
    private CreateTsukibetsuSuiihyoProcessParameter processPrm;
    private CreateTsukibetsuSuiihyoMyBatisParameter mybatisPrm;
    private ICreateTsukibetsuSuiihyoMapper iCreateTsukibetsuSuiihyoMapper;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 資格状況一時テーブル;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 介護情報一時テーブル;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 減免介護情報一時テーブル;

    @Override
    protected void initialize() {
        mybatisPrm = processPrm.toCreateTsukibetsuSuiihyoMyBatisParameter();
        iCreateTsukibetsuSuiihyoMapper = getMapper(ICreateTsukibetsuSuiihyoMapper.class);
        hihokenshaDaichoPsmList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        CreateTsukibetsuSuiihyoMyBatisParameter parameter
                = CreateTsukibetsuSuiihyoMyBatisParameter.create_被保険者台帳管理と宛名のデータ(
                        mybatisPrm.getChoteiNendo(), mybatisPrm.isAgeFlg(), mybatisPrm.getAgeStart(), mybatisPrm.getAgeEnd(),
                        mybatisPrm.getAgeKijunNi(), mybatisPrm.isSeinengappiYMDFlg(), mybatisPrm.getSeinengappiYMDStart(),
                        mybatisPrm.getSeinengappiYMDEnd(), mybatisPrm.getSentakuTaisho(), mybatisPrm.getSentakuKekkaList(),
                        mybatisPrm.getShichosonCode(), mybatisPrm.getKyuShichosonCode(),
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter);
    }

    @Override
    protected void createWriter() {
        資格状況一時テーブル = new BatchEntityCreatedTempTableWriter(TABLE_資格状況一時テーブル,
                HihokenshaDaichoPsm.class);
        介護情報一時テーブル = new BatchEntityCreatedTempTableWriter(TABLE_介護情報一時テーブル,
                GennendoDate.class);
        減免介護情報一時テーブル = new BatchEntityCreatedTempTableWriter(TABLE_減免介護情報一時テーブル,
                GennendoDate.class);
    }

    @Override
    protected void process(HihokenshaDaichoPsm psm) {
        hihokenshaDaichoPsmList.add(psm);
    }

    @Override
    protected void afterExecute() {
        set各月資格有無の判断();
        get現年度データ();
        過年度のデータの取得();
        不明のデータの取得();
        減免部分のデータの取得();
    }

    private void set各月資格有無の判断() {
        for (HihokenshaDaichoPsm psm : hihokenshaDaichoPsmList) {
            psm.setYoGetuSikakuumuFlg(get各月資格有無の判断(四月, psm));
            psm.setGoGetuSikakuumuFlg(get各月資格有無の判断(五月, psm));
            psm.setRokuGetuSikakuumuFlg(get各月資格有無の判断(六月, psm));
            psm.setNanaGetuSikakuumuFlg(get各月資格有無の判断(七月, psm));
            psm.setHatiGetuSikakuumuFlg(get各月資格有無の判断(八月, psm));
            psm.setKyuGetuSikakuumuFlg(get各月資格有無の判断(九月, psm));
            psm.setJyuGetuSikakuumuFlg(get各月資格有無の判断(十月, psm));
            psm.setJyuitiGetuSikakuumuFlg(get各月資格有無の判断(十一月, psm));
            psm.setJyuniGetuSikakuumuFlg(get各月資格有無の判断(十二月, psm));
            psm.setItiGetuSikakuumuFlg(get各月資格有無の判断(一月, psm));
            psm.setNiGetuSikakuumuFlg(get各月資格有無の判断(二月, psm));
            psm.setSanGetuSikakuumuFlg(get各月資格有無の判断(三月, psm));
            資格状況一時テーブル.insert(psm);
        }
    }

    private boolean get各月資格有無の判断(RString getu, HihokenshaDaichoPsm psm) {
        FlexibleDate 資格判断基準日;
        StringBuilder builder = new StringBuilder();
        builder.append(mybatisPrm.getChoteiNendo());
        builder.append(getu);
        builder.append(mybatisPrm.getKakutukiShikakuKijunNichi().trim().padZeroToLeft(2));
        資格判断基準日 = new FlexibleDate(builder.toString());
        return psm.getIchigoShikakuShutokuYMD().isBeforeOrEquals(資格判断基準日)
                && (psm.getShikakuSoshitsuYMD() == null || psm.getShikakuSoshitsuYMD().isEmpty()
                || 資格判断基準日.isBefore(psm.getShikakuSoshitsuYMD()));
    }

    private List<GennendoDate> get現年度データ() {
        List<GennendoDate> gennendoList = new ArrayList<>();
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_現年度データの取得(mybatisPrm.getChoteiNendo(), mybatisPrm.getChoteiKijunNichiji());
        List<GennendoDate> list = iCreateTsukibetsuSuiihyoMapper.get現年度データの取得(parameter);
        FuchoKiUtil fuchoKiUtil = new FuchoKiUtil();
        for (GennendoDate gennendoDate : list) {
            gennendoDate.setGetu(get期に対する月の設定(gennendoDate, fuchoKiUtil));
            if (普通徴収.equals(gennendoDate.getChoshuHouhou())) {
                Kitsuki kitsuki = fuchoKiUtil.get期月リスト().get最終法定納期();
                if (gennendoDate.getKi() > kitsuki.get期AsInt()) {
                    gennendoDate.setGetu(new RString("随"));
                }
            }
            介護情報一時テーブル.insert(gennendoDate);
            gennendoList.add(gennendoDate);
        }
        return gennendoList;
    }

    private RString get期に対する月の設定(GennendoDate gennendoDate, FuchoKiUtil fuchoKiUtil) {
        List<Kitsuki> itsukiList = new ArrayList<>();
        if (普通徴収.equals(gennendoDate.getChoshuHouhou())) {
            itsukiList = fuchoKiUtil.get期月リスト().get期の月(gennendoDate.getKi());
        }
        if (特別徴収.equals(gennendoDate.getChoshuHouhou())) {
            if (gennendoDate.getKi() == 1) {
                return Tsuki._4月.getコード();
            }
            if (gennendoDate.getKi() == 2) {
                return Tsuki._6月.getコード();
            }
            if (gennendoDate.getKi() == INT_3) {
                return Tsuki._8月.getコード();
            }
            if (gennendoDate.getKi() == INT_4) {
                return Tsuki._10月.getコード();
            }
            if (gennendoDate.getKi() == INT_5) {
                return Tsuki._12月.getコード();
            }
            if (gennendoDate.getKi() == INT_6) {
                return Tsuki._2月.getコード();
            }
        }
        return itsukiList.get(0).get月().getコード();
    }

    private void 過年度のデータの取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_過年度のデータの取得(mybatisPrm.getChoteiNendo(), mybatisPrm.getChoteiKijunNichiji());
        List<GennendoDate> list = iCreateTsukibetsuSuiihyoMapper.get過年度のデータの取得(parameter);
        for (GennendoDate gennendoDate : list) {
            gennendoDate.setGetu(RString.EMPTY);
            介護情報一時テーブル.insert(gennendoDate);
        }
    }

    private void 不明のデータの取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_不明のデータの取得(mybatisPrm.getChoteiNendo(), mybatisPrm.getChoteiKijunNichiji());
        List<GennendoDate> list = iCreateTsukibetsuSuiihyoMapper.get不明のデータの取得(parameter);
        FuchoKiUtil fuchoKiUtil = new FuchoKiUtil();
        for (GennendoDate gennendoDate : list) {
            gennendoDate.setGetu(get期に対する月の設定(gennendoDate, fuchoKiUtil));
            gennendoDate.setDankaiFumeyiFlg(true);
            介護情報一時テーブル.insert(gennendoDate);
        }
    }

    private void 減免部分のデータの取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_過年度のデータの取得(mybatisPrm.getChoteiNendo(), mybatisPrm.getChoteiKijunNichiji());
        List<GennendoDate> list = iCreateTsukibetsuSuiihyoMapper.get減免部分のデータの取得(parameter);
        for (GennendoDate gennendoDate : list) {
            減免介護情報一時テーブル.insert(gennendoDate);
        }
    }
}
