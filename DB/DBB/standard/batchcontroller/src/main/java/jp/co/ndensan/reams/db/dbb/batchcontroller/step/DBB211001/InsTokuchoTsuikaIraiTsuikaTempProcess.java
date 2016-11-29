/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsTokuchoTsuikaIraiTsuikaTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.ShikakuSoshitsuDataEntity;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.RenkeiGyomuShubetsu;
import jp.co.ndensan.reams.ue.uex.definition.core.RenkeiJohoShubetsu;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * （特徴追加依頼）追加用データ作成します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsTokuchoTsuikaIraiTsuikaTempProcess extends BatchProcessBase<ShikakuSoshitsuDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get特徴追加依頼追加用データ");
    private static final RString TEMP_TABLE = new RString("特徴追加依頼追加Temp");
    private static final RString DT各種区分_01 = new RString("01");
    private static final RString DT各種区分_02 = new RString("02");
    private static final RString DT各種区分_03 = new RString("03");
    private static final RString 特別徴収_厚生労働省 = new RString("1");
    private static final RString 特別徴収_地共済 = new RString("2");
    private static final RString 住所地特例フラグ_1 = new RString("1");
    private static final int 期1 = 1;
    private static final int 期2 = 2;
    private static final int 期3 = 3;
    private static final int 期4 = 4;
    private static final int 期5 = 5;
    private static final int 期6 = 6;
    private static final int TWO = 2;
    private static final int 捕捉月の６カ月後_1月 = 1;
    private static final int 捕捉月の６カ月後_2月 = 2;
    private static final int 捕捉月の６カ月後_3月 = 3;
    private static final int 捕捉月の６カ月後_4月 = 4;
    private static final int 捕捉月の６カ月後_5月 = 5;
    private static final int 捕捉月の６カ月後_6月 = 6;
    private static final int 捕捉月の６カ月後_7月 = 7;
    private static final int 捕捉月の６カ月後_8月 = 8;
    private static final int 捕捉月の６カ月後_9月 = 9;
    private static final int 捕捉月の６カ月後_10月 = 10;
    private static final int 捕捉月の６カ月後_11月 = 11;
    private static final int 捕捉月の６カ月後_12月 = 12;
    private static final int 捕捉月の６カ月後の取得用 = 6;
    private static final RString 各種金額_全桁0設定 = new RString("00000000000");
    private static final RString DT媒体コード_回線 = new RString("6");
    private static final RString 国保世帯コードが0 = new RString("0");

    private InsTokuchoTsuikaIraiTsuikaTempProcessParameter parameter;
    private DbT2002FukaJohoTempTableEntity 業務概念_賦課の情報;
    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者の情報;
    private TsuchishoNo 通知書番号;
    private FlexibleYear 賦課年度;
    private FlexibleYear 調定年度;
    @BatchWriter
    BatchEntityCreatedTempTableWriter<UeT0511NenkinTokuchoKaifuJohoEntity> 特徴追加依頼追加Temp;

    @Override
    protected void initialize() {
    }

    @Override
    protected void createWriter() {
        特徴追加依頼追加Temp = new BatchEntityCreatedTempTableWriter(
                TEMP_TABLE, UeT0511NenkinTokuchoKaifuJohoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toSelectTokuchoTsuikaIraiTsuikaTempMyBatisParameter());

    }

    @Override
    protected void process(ShikakuSoshitsuDataEntity t) {
        if (!t.get賦課情報().getTsuchishoNo().equals(通知書番号)
                || !t.get賦課情報().getFukaNendo().equals(賦課年度)
                || !t.get賦課情報().getChoteiNendo().equals(調定年度)) {
            if (通知書番号 != null) {
                setDT各種金額欄(対象者の情報);
                特徴追加依頼追加Temp.insert(対象者の情報);
            }
            業務概念_賦課の情報 = new DbT2002FukaJohoTempTableEntity();
            対象者の情報 = 対象者の情報を編集(t);
        }
        set特徴期期別金額(t.get調定額(), t.get期(), 業務概念_賦課の情報);
        通知書番号 = t.get賦課情報().getTsuchishoNo();
        賦課年度 = t.get賦課情報().getFukaNendo();
        調定年度 = t.get賦課情報().getChoteiNendo();
    }

    @Override
    protected void afterExecute() {
        if (通知書番号 != null) {
            setDT各種金額欄(対象者の情報);
            特徴追加依頼追加Temp.insert(対象者の情報);
        }
    }

    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者の情報を編集(ShikakuSoshitsuDataEntity t) {
        DbT1001HihokenshaDaichoEntity 資格情報 = t.get資格情報();
        DbT2001ChoshuHohoEntity 徴収方法情報 = t.get徴収方法情報();
        UeT0511NenkinTokuchoKaifuJohoEntity 対象者情報 = t.get対象者情報();
        FlexibleYear 処理年度 = new FlexibleYear(parameter.get賦課年度().toDateString());
        RString 通知内容コード = TsuchiNaiyoCodeType.特別徴収追加依頼通知.get通知内容コード();
        FlexibleYearMonth 処理対象年月 = get処理対象年月();
        RDateTime 処理日時 = parameter.getシステム日時().getRDateTime();
        RString 連携種別 = RenkeiGyomuShubetsu.介護特別徴収.getコード()
                .concat(RenkeiJohoShubetsu.各種異動情報.getコード());
        RString dT通知内容コード = TsuchiNaiyoCodeType.特別徴収追加依頼通知.get通知内容コード();
        RString dT作成年月日 = parameter.getシステム日時().getDate().toDateString();
        RString dT各種区分 = getDT各種区分(徴収方法情報, 対象者情報, 資格情報);
        SetaiCode 国保世帯コード = new SetaiCode(国保世帯コードが0);
        対象者情報.setShoriNendo(処理年度);
        対象者情報.setTsuchiNaiyoCode(通知内容コード);
        対象者情報.setShoriTaishoYM(処理対象年月);
        対象者情報.setShoriTimestamp(処理日時);
        対象者情報.setRenkeiShubetsu(連携種別);
        対象者情報.setDtTsuchiNaiyoCode(dT通知内容コード);
        対象者情報.setDtBaitaiCode(DT媒体コード_回線);
        対象者情報.setDtSakuseiYMD(dT作成年月日);
        対象者情報.setDtYobi1(RString.EMPTY);
        対象者情報.setDtKakushuKubun(dT各種区分);
        対象者情報.setDtShoriKekka(RString.EMPTY);
        対象者情報.setDtKokiIkanCode(RString.EMPTY);
        対象者情報.setDtKakushuYMD(parameter.getシステム日時().getDate().toDateString());
        対象者情報.setDtKakushuKingaku2(各種金額_全桁0設定);
        対象者情報.setDtYobi2(RString.EMPTY);
        対象者情報.setDtKyosaiNenkinshoshoKigoNo(RString.EMPTY);
        if (!DT各種区分_03.equals(dT各種区分)) {
            対象者情報.setShikibetsuCode(資格情報.getShikibetsuCode());
            対象者情報.setHihokenshaNo(資格情報.getHihokenshaNo().value());
        } else {
            対象者情報.setShikibetsuCode(ShikibetsuCode.EMPTY);
        }
        対象者情報.setKokuhoSetaiCode(国保世帯コード);
        対象者情報.setDtKakushuKingaku4(RString.EMPTY);
        対象者情報.setDtKakushuKingaku5(RString.EMPTY);
        対象者情報.setDtKakushuKingaku6(RString.EMPTY);
        対象者情報.setDtKakushuKingaku7(RString.EMPTY);
        対象者情報.setDtKakushuKingaku8(RString.EMPTY);
        対象者情報.setDtTeishiYM(RString.EMPTY);
        対象者情報.setDtYobi4Juminzei(RString.EMPTY);
        対象者情報.setDtKojinNo(RString.EMPTY);
        return 対象者情報;
    }

    private FlexibleYearMonth get処理対象年月() {
        return new FlexibleYearMonth(parameter.get賦課年度().toDateString().concat(parameter.get処理対象月()));
    }

    private void setDT各種金額欄(UeT0511NenkinTokuchoKaifuJohoEntity 対象者情報) {
        対象者情報.setDtKakushuKingaku1(getDT各種金額欄(対象者情報.getDtKakushuKubun(), 対象者情報.getHosokuTsuki()));
    }

    private RString getDT各種区分(DbT2001ChoshuHohoEntity 徴収方法の情報,
            UeT0511NenkinTokuchoKaifuJohoEntity 対象者情報, DbT1001HihokenshaDaichoEntity 資格情報) {
        if (徴収方法の情報 == null) {
            return DT各種区分_03;
        }
        RYearMonth 年月 = new RYearMonth(parameter.get賦課年度().toDateString().concat(対象者情報.getHosokuTsuki()));
        int 捕捉月の６カ月後 = 年月.plusMonth(捕捉月の６カ月後の取得用).getMonthValue();
        RString 徴収方法ｎ月 = get徴収方法ｎ月(捕捉月の６カ月後, 徴収方法の情報);
        if ((特別徴収_厚生労働省.equals(徴収方法ｎ月)
                || 特別徴収_地共済.equals(徴収方法ｎ月))
                && 資格情報.getShikakuSoshitsuJiyuCode() != null
                && !住所地特例フラグ_1.equals(資格情報.getJushochiTokureiFlag())) {
            return DT各種区分_01;
        }
        if ((特別徴収_厚生労働省.equals(徴収方法ｎ月)
                || 特別徴収_地共済.equals(徴収方法ｎ月))
                && 資格情報.getShikakuSoshitsuJiyuCode() == null
                && 住所地特例フラグ_1.equals(資格情報.getJushochiTokureiFlag())) {
            return DT各種区分_02;
        }
        if (!(特別徴収_厚生労働省.equals(徴収方法ｎ月)
                || 特別徴収_地共済.equals(徴収方法ｎ月))) {
            return DT各種区分_03;
        }
        return RString.EMPTY;
    }

    private RString get徴収方法ｎ月(int 捕捉月の６カ月後, DbT2001ChoshuHohoEntity 徴収方法の情報) {
        RString 徴収方法ｎ月 = RString.EMPTY;
        switch (捕捉月の６カ月後) {
            case 捕捉月の６カ月後_1月:
                徴収方法ｎ月 = 徴収方法の情報.getChoshuHoho1gatsu();
                break;
            case 捕捉月の６カ月後_2月:
                徴収方法ｎ月 = 徴収方法の情報.getChoshuHoho2gatsu();
                break;
            case 捕捉月の６カ月後_3月:
                徴収方法ｎ月 = 徴収方法の情報.getChoshuHoho3gatsu();
                break;
            case 捕捉月の６カ月後_4月:
                徴収方法ｎ月 = 徴収方法の情報.getChoshuHoho4gatsu();
                break;
            case 捕捉月の６カ月後_5月:
                徴収方法ｎ月 = 徴収方法の情報.getChoshuHoho5gatsu();
                break;
            case 捕捉月の６カ月後_6月:
                徴収方法ｎ月 = 徴収方法の情報.getChoshuHoho6gatsu();
                break;
            case 捕捉月の６カ月後_7月:
                徴収方法ｎ月 = 徴収方法の情報.getChoshuHoho7gatsu();
                break;
            case 捕捉月の６カ月後_8月:
                徴収方法ｎ月 = 徴収方法の情報.getChoshuHoho8gatsu();
                break;
            case 捕捉月の６カ月後_9月:
                徴収方法ｎ月 = 徴収方法の情報.getChoshuHoho9gatsu();
                break;
            case 捕捉月の６カ月後_10月:
                徴収方法ｎ月 = 徴収方法の情報.getChoshuHoho10gatsu();
                break;
            case 捕捉月の６カ月後_11月:
                徴収方法ｎ月 = 徴収方法の情報.getChoshuHoho11gatsu();
                break;
            case 捕捉月の６カ月後_12月:
                徴収方法ｎ月 = 徴収方法の情報.getChoshuHoho12gatsu();
                break;
            default:
                break;
        }
        return 徴収方法ｎ月;
    }

    private RString getDT各種金額欄(RString dT各種区分, RString 捕捉月) {
        if (DT各種区分_01.equals(dT各種区分) || DT各種区分_02.equals(dT各種区分)) {
            KitsukiList 期月リスト = new TokuchoKiUtil().get期月リスト();
            RYearMonth 年月 = new RYearMonth(parameter.get賦課年度().toDateString().concat(捕捉月));
            RString 特徴開始月 = new RString(年月.plusMonth(捕捉月の６カ月後の取得用).getMonthValue()).padZeroToLeft(TWO);
            Tsuki 月 = Tsuki.toValue(特徴開始月);
            RString 期 = 期月リスト.get月の期(月).get期();
            return get特徴期期別金額(Integer.parseInt(期.toString()));
        }
        if (DT各種区分_03.equals(dT各種区分)) {
            return 各種金額_全桁0設定;
        }
        return RString.EMPTY;
    }

    private RString get特徴期期別金額(int 期) {
        Decimal 特徴期期別金額;
        switch (期) {
            case 期1:
                特徴期期別金額 = 業務概念_賦課の情報.getTkKibetsuGaku01();
                break;
            case 期2:
                特徴期期別金額 = 業務概念_賦課の情報.getTkKibetsuGaku02();
                break;
            case 期3:
                特徴期期別金額 = 業務概念_賦課の情報.getTkKibetsuGaku03();
                break;
            case 期4:
                特徴期期別金額 = 業務概念_賦課の情報.getTkKibetsuGaku04();
                break;
            case 期5:
                特徴期期別金額 = 業務概念_賦課の情報.getTkKibetsuGaku05();
                break;
            case 期6:
                特徴期期別金額 = 業務概念_賦課の情報.getTkKibetsuGaku06();
                break;
            default:
                特徴期期別金額 = null;
                break;
        }
        if (特徴期期別金額 != null) {
            return new RString(特徴期期別金額.toString());
        }
        return RString.EMPTY;
    }

    private void set特徴期期別金額(Decimal choteigaku, int ki, DbT2002FukaJohoTempTableEntity 処理前賦課Temp情報) {
        switch (ki) {
            case 期1:
                処理前賦課Temp情報.setTkKibetsuGaku01(choteigaku);
                break;
            case 期2:
                処理前賦課Temp情報.setTkKibetsuGaku02(choteigaku);
                break;
            case 期3:
                処理前賦課Temp情報.setTkKibetsuGaku03(choteigaku);
                break;
            case 期4:
                処理前賦課Temp情報.setTkKibetsuGaku04(choteigaku);
                break;
            case 期5:
                処理前賦課Temp情報.setTkKibetsuGaku05(choteigaku);
                break;
            case 期6:
                処理前賦課Temp情報.setTkKibetsuGaku06(choteigaku);
                break;
            default:
                break;
        }
    }

}
