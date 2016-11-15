/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB271001;

import java.util.AbstractMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshadotei.TokuchoTaishoshaDoteiMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchotaishoshadotei.CreateGyomuHokenshaJohoGetsujiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshadotei.TokuchoTaishoshaDoteiCombineEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.ue.uex.definition.core.DoteiFuitchiRiyu;
import jp.co.ndensan.reams.ue.uex.entity.relate.GyomuHihokenshaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * 特徴対象者同定（一括）のバッチフロークラス<br>
 * 業務被保険者情報作成（月次）
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
public class CreateGyomuHokenshaJohoGetsujiProcess extends BatchProcessBase<TokuchoTaishoshaDoteiCombineEntity> {

    private CreateGyomuHokenshaJohoGetsujiProcessParameter parameter;
    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchotaishoshadotei.ITokuchoTaishoshaDoteiMapper.get介護の３つのテーブルと徴収方法の全件");

    private static final RString 徴収方法_1月 = new RString("01");
    private static final RString 徴収方法_2月 = new RString("02");
    private static final RString 徴収方法_3月 = new RString("03");
    private static final RString 徴収方法_4月 = new RString("04");
    private static final RString 徴収方法_5月 = new RString("05");
    private static final RString 徴収方法_6月 = new RString("06");
    private static final RString 徴収方法_7月 = new RString("07");
    private static final RString 徴収方法_8月 = new RString("08");
    private static final RString 徴収方法_9月 = new RString("09");
    private static final RString 徴収方法_10月 = new RString("10");
    private static final RString 徴収方法_11月 = new RString("11");
    private static final RString 徴収方法_12月 = new RString("12");

    /**
     * TABLE_NAME
     */
    public static final RString TABLE_NAME;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 業務被保険者情報一時tableWriter;

    static {
        TABLE_NAME = new RString("GyomuHihokenshaTemp");
    }

    @Override
    protected IBatchReader createReader() {
        TokuchoTaishoshaDoteiMybatisParameter mybatisParameter = new TokuchoTaishoshaDoteiMybatisParameter();
        mybatisParameter.set処理年度(parameter.get処理年度());
        return new BatchDbReader(ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        業務被保険者情報一時tableWriter
                = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                        GyomuHihokenshaTempEntity.class);
    }

    @Override
    protected void process(TokuchoTaishoshaDoteiCombineEntity entity) {
        FlexibleDate now = FlexibleDate.getNowDate();
        Map.Entry<ShikibetsuCode, DoteiFuitchiRiyu> entry = get不一致理由_月次(entity, now, parameter.get開始月());

        GyomuHihokenshaTempEntity 業務被保険者情報一時 = new GyomuHihokenshaTempEntity();
        業務被保険者情報一時.setShikibetsuCode(entry.getKey().getColumnValue());
        if (null == entry.getValue()) {
            業務被保険者情報一時.setFuitchiRiyuCode(null);
        } else {
            業務被保険者情報一時.setFuitchiRiyuCode(entry.getValue().getコード());
        }
        業務被保険者情報一時.setState(EntityDataState.Added);
        業務被保険者情報一時tableWriter.insert(業務被保険者情報一時);
    }

    private Map.Entry<ShikibetsuCode, DoteiFuitchiRiyu> get不一致理由_月次(TokuchoTaishoshaDoteiCombineEntity entity,
            FlexibleDate now, RString 開始月) {
        DoteiFuitchiRiyu 不一致理由;
        if (null != entity.getHihokensha() && null != entity.getHihokensha().getShikibetsuCode()) {
            boolean 資格喪失flag = do資格喪失の判定(entity.getHihokensha(), now);
            if (!資格喪失flag) {
                不一致理由 = do徴収方法の不一致理由(entity.getChoshuhoho(), 開始月);
            } else {
                不一致理由 = do他市町村住所地特例者台帳時不一致理由(entity.getTokurei(), entity.getJogaisha(), true);
            }
        } else {
            不一致理由 = do他市町村住所地特例者台帳時不一致理由(entity.getTokurei(), entity.getJogaisha(), false);
        }
        if (null != entity.getHihokensha() && null != entity.getHihokensha().getShikibetsuCode()) {
            return new AbstractMap.SimpleEntry(entity.getHihokensha().getShikibetsuCode(), 不一致理由);
        } else if (null != entity.getTokurei() && null != entity.getTokurei().getShikibetsuCode()) {
            return new AbstractMap.SimpleEntry(entity.getTokurei().getShikibetsuCode(), 不一致理由);
        } else {
            return new AbstractMap.SimpleEntry(entity.getJogaisha().getShikibetsuCode(), 不一致理由);
        }
    }

    private boolean do資格喪失の判定(DbV1001HihokenshaDaichoEntity 被保険者, FlexibleDate now) {
        return !(ShikakuKubun._１号.getコード().equals(被保険者.getHihokennshaKubunCode())
                && (null != 被保険者.getIchigoShikakuShutokuYMD()
                && !FlexibleDate.EMPTY.equals(被保険者.getIchigoShikakuShutokuYMD())
                && 被保険者.getIchigoShikakuShutokuYMD().isBeforeOrEquals(now))
                && (null == 被保険者.getShikakuSoshitsuYMD() || FlexibleDate.EMPTY.equals(被保険者.getShikakuSoshitsuYMD())
                || now.isBeforeOrEquals(被保険者.getShikakuSoshitsuYMD())) && !被保険者.getLogicalDeletedFlag());
    }

    private DoteiFuitchiRiyu do他市町村住所地特例者台帳時不一致理由(DbV1003TashichosonJushochiTokureiEntity tokurei,
            DbV1002TekiyoJogaishaEntity jogaisha, boolean 被保険者台帳があるFlag) {
        if (null != tokurei && null != tokurei.getShikibetsuCode()) {
            FlexibleDate 解除年月日 = tokurei.getKaijoYMD();
            if (null == 解除年月日 || 解除年月日.equals(FlexibleDate.EMPTY)) {
                return DoteiFuitchiRiyu.資格なし_他特例者;
            }
            return DoteiFuitchiRiyu.資格なし;
        } else if (null != jogaisha && null != jogaisha.getShikibetsuCode()) {
            FlexibleDate 解除年月日 = jogaisha.getKaijoYMD();
            if (null == 解除年月日 || 解除年月日.equals(FlexibleDate.EMPTY)) {
                return DoteiFuitchiRiyu.資格なし_適用除外者;
            }
            return DoteiFuitchiRiyu.資格なし;
        } else if (被保険者台帳があるFlag) {
            return DoteiFuitchiRiyu.資格喪失;
        }
        return null;
    }

    private DoteiFuitchiRiyu do徴収方法の不一致理由(DbV2001ChoshuHohoEntity 徴収方法, RString 開始月) {
        if (null != 徴収方法) {
            RString 徴収方法X月 = get徴収方法X月(徴収方法, 開始月);
            if (ChoshuHoho.特別徴収_厚生労働省.getコード().equals(徴収方法X月)
                    || ChoshuHoho.特別徴収_地共済.getコード().equals(徴収方法X月)) {
                return DoteiFuitchiRiyu.特徴対象者登録済;
            }
        }
        return null;
    }

    private RString get徴収方法X月(DbV2001ChoshuHohoEntity 徴収方法, RString 開始月) {
        if (RString.isNullOrEmpty(開始月)) {
            return RString.EMPTY;
        }
        if (徴収方法_1月.equals(開始月)) {
            return 徴収方法.getChoshuHoho1gatsu();
        }
        if (徴収方法_2月.equals(開始月)) {
            return 徴収方法.getChoshuHoho2gatsu();
        }
        if (徴収方法_3月.equals(開始月)) {
            return 徴収方法.getChoshuHoho3gatsu();
        }
        if (徴収方法_4月.equals(開始月)) {
            return 徴収方法.getChoshuHoho4gatsu();
        }
        if (徴収方法_5月.equals(開始月)) {
            return 徴収方法.getChoshuHoho5gatsu();
        }
        if (徴収方法_6月.equals(開始月)) {
            return 徴収方法.getChoshuHoho6gatsu();
        }
        if (徴収方法_7月.equals(開始月)) {
            return 徴収方法.getChoshuHoho7gatsu();
        }
        if (徴収方法_8月.equals(開始月)) {
            return 徴収方法.getChoshuHoho8gatsu();
        }
        if (徴収方法_9月.equals(開始月)) {
            return 徴収方法.getChoshuHoho9gatsu();
        }
        if (徴収方法_10月.equals(開始月)) {
            return 徴収方法.getChoshuHoho10gatsu();
        }
        if (徴収方法_11月.equals(開始月)) {
            return 徴収方法.getChoshuHoho11gatsu();
        }
        if (徴収方法_12月.equals(開始月)) {
            return 徴収方法.getChoshuHoho12gatsu();
        }
        return RString.EMPTY;
    }

}
