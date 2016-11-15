/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsNenkinTokuchoKaifuJoho1ProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.TokuchoIraiDataEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.RenkeiGyomuShubetsu;
import jp.co.ndensan.reams.ue.uex.definition.core.RenkeiJohoShubetsu;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * （特徴依頼）追加用データ作成します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsNenkinTokuchoKaifuJoho1Process extends BatchProcessBase<TokuchoIraiDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.特徴依頼のデータを取得");
    private static final RString TEMP_TABLE = new RString("特徴依頼追加Temp");
    private static final RString DT媒体コード_回線 = new RString("6");
    private static final RString DT各種区分_01 = new RString("01");
    private static final RString DT各種区分_02 = new RString("02");
    private static final RString DT各種区分_03 = new RString("03");
    private static final RString 特別徴収_厚生労働省 = new RString("1");
    private static final RString 特別徴収_地共済 = new RString("2");
    private static final RString 住所地特例フラグ_1 = new RString("1");
    private static final RString 国保世帯コードが0 = new RString("0");

    private static final int 期1 = 1;
    private static final int 期2 = 2;
    private static final int 期3 = 3;
    private static final int 期4 = 4;
    private static final int 期5 = 5;
    private static final int 期6 = 6;

    private InsNenkinTokuchoKaifuJoho1ProcessParameter parameter;
    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者の情報;
    private TsuchishoNo 通知書番号;
    private FlexibleYear 賦課年度;
    private FlexibleYear 調定年度;
    private DbT2002FukaJohoTempTableEntity 賦課Temp情報;

    @BatchWriter
    BatchPermanentTableWriter 年金特徴回付情報TableWriter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<UeT0511NenkinTokuchoKaifuJohoEntity> 特徴依頼追加Temp;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toSelectTokuChoIraiDataMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        年金特徴回付情報TableWriter = new BatchPermanentTableWriter(UeT0511NenkinTokuchoKaifuJohoEntity.class);
        特徴依頼追加Temp = new BatchEntityCreatedTempTableWriter(
                TEMP_TABLE, UeT0511NenkinTokuchoKaifuJohoEntity.class);
    }

    @Override
    protected void process(TokuchoIraiDataEntity t) {
        if (t.get賦課Newest() == null) {
            return;
        }
        if (!t.get賦課Newest().getTsuchishoNo().equals(通知書番号)
                || !t.get賦課Newest().getFukaNendo().equals(賦課年度)
                || !t.get賦課Newest().getChoteiNendo().equals(調定年度)) {
            if (通知書番号 != null) {
                dT各種金額欄１とDT各種金額欄2を編集(対象者の情報);
                特徴依頼追加Temp.insert(対象者の情報);
                年金特徴回付情報TableWriter.insert(対象者の情報);
            }
            賦課Temp情報 = new DbT2002FukaJohoTempTableEntity();
            対象者の情報 = 対象者の情報を編集(t);
        }
        set特徴期期別金額(t.get調定額(), t.get期(), 賦課Temp情報);
        通知書番号 = t.get賦課Newest().getTsuchishoNo();
        賦課年度 = t.get賦課Newest().getFukaNendo();
        調定年度 = t.get賦課Newest().getChoteiNendo();

    }

    @Override
    protected void afterExecute() {
        if (通知書番号 != null) {
            dT各種金額欄１とDT各種金額欄2を編集(対象者の情報);
            特徴依頼追加Temp.insert(対象者の情報);
            年金特徴回付情報TableWriter.insert(対象者の情報);
        }
    }

    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者の情報を編集(TokuchoIraiDataEntity t) {
        DbT2001ChoshuHohoEntity 徴収方法Newest = t.get徴収方法Newest();
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理Newest = t.get被保険者台帳管理Newest();
        UeT0511NenkinTokuchoKaifuJohoEntity entity = t.get対象者情報();
        FlexibleYear 処理年度 = new FlexibleYear(parameter.get賦課年度().toDateString());
        RString 通知内容コード = TsuchiNaiyoCodeType.特別徴収依頼通知.get通知内容コード();
        FlexibleYearMonth 処理対象年月 = get処理対象年月();
        RDateTime 処理日時 = parameter.getシステム日時().getRDateTime();
        RString 連携種別 = RenkeiGyomuShubetsu.介護特別徴収.getコード()
                .concat(RenkeiJohoShubetsu.依頼情報.getコード());
        RString dT通知内容コード = TsuchiNaiyoCodeType.特別徴収依頼通知.get通知内容コード();
        RString dT作成年月日 = parameter.getシステム日時().getDate().toDateString();
        RString dT各種区分 = getDT各種区分(徴収方法Newest, 被保険者台帳管理Newest);
        RString dT各種年月日 = parameter.getシステム日時().getDate().toDateString();

        SetaiCode 国保世帯コード = new SetaiCode(国保世帯コードが0);
        entity.setShoriNendo(処理年度);
        entity.setTsuchiNaiyoCode(通知内容コード);
        entity.setShoriTaishoYM(処理対象年月);
        entity.setShoriTimestamp(処理日時);
        entity.setRenkeiShubetsu(連携種別);
        entity.setDtTsuchiNaiyoCode(dT通知内容コード);
        entity.setDtBaitaiCode(DT媒体コード_回線);
        entity.setDtSakuseiYMD(dT作成年月日);
        entity.setDtYobi1(RString.EMPTY);
        entity.setDtKakushuKubun(dT各種区分);
        entity.setDtShoriKekka(RString.EMPTY);
        entity.setDtKokiIkanCode(RString.EMPTY);
        entity.setDtKakushuYMD(dT各種年月日);

        entity.setDtYobi2(RString.EMPTY);
        if (!DT各種区分_03.equals(dT各種区分) && 被保険者台帳管理Newest != null) {
            entity.setShikibetsuCode(被保険者台帳管理Newest.getShikibetsuCode());
            entity.setHihokenshaNo(被保険者台帳管理Newest.getHihokenshaNo().value());
        }
        entity.setKokuhoSetaiCode(国保世帯コード);
        entity.setDtKakushuKingaku4(RString.EMPTY);
        entity.setDtKakushuKingaku5(RString.EMPTY);
        entity.setDtKakushuKingaku6(RString.EMPTY);
        entity.setDtKakushuKingaku7(RString.EMPTY);
        entity.setDtKakushuKingaku8(RString.EMPTY);
        entity.setDtTeishiYM(RString.EMPTY);
        entity.setDtYobi4Juminzei(RString.EMPTY);
        entity.setDtKojinNo(RString.EMPTY);
        return entity;
    }

    private void dT各種金額欄１とDT各種金額欄2を編集(UeT0511NenkinTokuchoKaifuJohoEntity entity) {
        RString dT各種金額欄１ = new RString(Decimal.ZERO.toString());
        RString dT各種金額欄2 = new RString(Decimal.ZERO.toString());
        if (賦課Temp情報 != null) {
            dT各種金額欄１ = get金額(賦課Temp情報.getTkKibetsuGaku04());
            dT各種金額欄2 = get金額(賦課Temp情報.getTkKibetsuGaku05());
        }
        entity.setDtKakushuKingaku1(dT各種金額欄１);
        entity.setDtKakushuKingaku2(dT各種金額欄2);
    }

    private FlexibleYearMonth get処理対象年月() {
        return new FlexibleYearMonth(parameter.get賦課年度().toDateString().concat(parameter.get処理対象月()));
    }

    private RString getDT各種区分(DbT2001ChoshuHohoEntity 徴収方法の情報,
            DbT1001HihokenshaDaichoEntity 資格の情報) {
        if (徴収方法の情報 == null) {
            return DT各種区分_03;
        }
        if ((特別徴収_厚生労働省.equals(徴収方法の情報.getChoshuHoho10gatsu())
                || 特別徴収_地共済.equals(徴収方法の情報.getChoshuHoho10gatsu()))
                && 資格の情報.getShikakuSoshitsuJiyuCode() != null
                && !住所地特例フラグ_1.equals(資格の情報.getJushochiTokureiFlag())) {
            return DT各種区分_01;
        }
        if ((特別徴収_厚生労働省.equals(徴収方法の情報.getChoshuHoho10gatsu())
                || 特別徴収_地共済.equals(徴収方法の情報.getChoshuHoho10gatsu()))
                && 資格の情報.getShikakuSoshitsuJiyuCode() == null
                && 住所地特例フラグ_1.equals(資格の情報.getJushochiTokureiFlag())) {
            return DT各種区分_02;
        }
        return DT各種区分_03;
    }

    private RString get金額(Decimal 金額) {
        if (金額 != null) {
            return new RString(金額.toString());
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
