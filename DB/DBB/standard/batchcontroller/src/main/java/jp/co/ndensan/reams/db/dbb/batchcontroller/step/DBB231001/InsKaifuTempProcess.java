/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB231001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshaichiransakusei.TokuchoSeidokanIFSakuseiMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiDBUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年金特徴回付情報の抽出のプロセスクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class InsKaifuTempProcess extends BatchProcessBase<
        UeT0511NenkinTokuchoKaifuJohoEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper."
            + "relate.tokuchosoufujohosakusei.IUeT0511Mapper");
    private static final RString SELECT = new RString(".select");
    private static final RString SELECTFEB = new RString(".selectFeb");
    private static final RString SELECTAPR = new RString(".selectApr");
    private static final RString SELECTJUN = new RString(".selectJun");
    private static final RString SELECTAUG = new RString(".selectAug");
    private static final RString SELECTOCT = new RString(".selectOct");
    private static final RString SELECTDEC = new RString(".selectDec");
    private final RString 月2 = new RString("02");
    private final RString 月4 = new RString("04");
    private final RString 月6 = new RString("06");
    private final RString 月8 = new RString("08");
    private final RString 月10 = new RString("10");
    private final RString 月12 = new RString("12");
    private static final RString RS30 = new RString("30");
    private static final RString RS00 = new RString("00");
    private static final RString 特徴制度間IF全件作成 = new RString("DBBMN84002");
    private static final RString 特徴制度間IF作成 = new RString("DBBMN84001");
    private RString path;
    private static final RString T_特徴回付情報TMP = new RString("NenkinTokuchoKaifuJohoTemp");
    private TokuchoSeidokanIFSakuseiDBUpdateProcessParameter parameter;
    private TokuchoSeidokanIFSakuseiMyBatisParameter param;
    @BatchWriter
    private IBatchTableWriter<UeT0511NenkinTokuchoKaifuJohoEntity> 特徴回付情報Temp;

    @Override
    protected void initialize() {
        param = new TokuchoSeidokanIFSakuseiMyBatisParameter(parameter.get処理年度());
        int 特徴開始年数 = parameter.get特別徴収開始年月().getYearValue();
        RString 特徴開始月数 = DateConverter.formatMonthFull(parameter.get特別徴収開始年月().getMonthValue());
        FlexibleYear 入力処理年度 = null;
        RString 通知内容コード = null;
        RString 捕捉月 = RString.EMPTY;
        RString 遷移元メニュー = parameter.get遷移元メニュー();
        if (月8.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                path = MAPPERPATH.concat(SELECTAUG);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数));
            通知内容コード = RS30;
            捕捉月 = 月2;
        } else if (月10.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                path = MAPPERPATH.concat(SELECTOCT);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数));
            通知内容コード = RS00;
            捕捉月 = 月4;
        } else if (月12.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                path = MAPPERPATH.concat(SELECTDEC);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数));
            通知内容コード = RS30;
            捕捉月 = 月6;
        } else if (月2.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                path = MAPPERPATH.concat(SELECTFEB);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数 - 1));
            通知内容コード = RS30;
            捕捉月 = 月8;
        } else if (月4.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                path = MAPPERPATH.concat(SELECTAPR);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数 - 1));
            通知内容コード = RS30;
            捕捉月 = 月10;
        } else if (月6.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                path = MAPPERPATH.concat(SELECTJUN);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数 - 1));
            通知内容コード = RS30;
            捕捉月 = 月12;
        }
        if (特徴制度間IF作成.equals(遷移元メニュー)) {
            param = new TokuchoSeidokanIFSakuseiMyBatisParameter(
                    入力処理年度, 通知内容コード, 捕捉月);
            path = MAPPERPATH.concat(SELECT);
        }
    }

    @Override
    protected void createWriter() {
        特徴回付情報Temp = new BatchEntityCreatedTempTableWriter<>(T_特徴回付情報TMP,
                UeT0511NenkinTokuchoKaifuJohoEntity.class);
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(path, param);
    }

    @Override
    protected void process(UeT0511NenkinTokuchoKaifuJohoEntity entity) {
        特徴回付情報Temp.insert(entity);
    }
}
