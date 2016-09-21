/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB271001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshadotei.TokuchoTaishoshaDoteiMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchotaishoshadotei.GetDoteiJohoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshadotei.DoteiIchijiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshadotei.TokuchoTaishoshaDoteiCombineEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchotaishoshadotei.ITokuchoTaishoshaDoteiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaGroupCode;
import jp.co.ndensan.reams.ue.uex.entity.relate.DoteiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * 特徴対象者同定（一括）のバッチフロークラス<br>
 * 同定情報を取得する
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
public class CreateChoshuHohoJohoProcess extends BatchProcessBase<TokuchoTaishoshaDoteiCombineEntity> {

    private GetDoteiJohoProcessParameter parameter;
    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchotaishoshadotei.ITokuchoTaishoshaDoteiMapper.get徴収方法情報");
    private RString 徴収種類;

    private static final RString 開始月_02 = new RString("02");
    private static final RString 開始月_04 = new RString("04");
    private static final RString 開始月_06 = new RString("06");
    private static final RString 開始月_08 = new RString("08");
    private static final RString 開始月_10 = new RString("10");
    private static final RString 開始月_12 = new RString("12");

    private static final RString 年度内連番_0001 = new RString("0001");
    private static final RString 年度内連番_0002 = new RString("0002");
    private static final RString 年度内連番_0003 = new RString("0003");
    private static final RString 年度内連番_0004 = new RString("0004");
    private static final RString 年度内連番_0005 = new RString("0005");
    private static final RString 年度内連番_0006 = new RString("0006");

    private static final RString 徴収種類_仮徴収 = new RString("仮徴収");
    private static final RString 徴収種類_本徴収 = new RString("本徴収");
    private static final RString 徴収種類_翌年度仮徴収 = new RString("翌年度仮徴収");
    private static final RString 地方公務員共済組合連合会 = new RString("001");
    /**
     * TABLE_NAME
     */
    public static final RString TABLE_NAME;

    private ITokuchoTaishoshaDoteiMapper mapper;
    private List<TokubetsuChoshuGimushaCode> 特別徴収義務者コードList;

    @BatchWriter
    BatchEntityCreatedTempTableWriter doteiTempTableWriter;
    @BatchWriter
    BatchPermanentTableWriter 介護徴収方法tableWriter;

    static {
        TABLE_NAME = new RString("DoteiTemp");
    }

    @Override
    protected IBatchReader createReader() {
        TokuchoTaishoshaDoteiMybatisParameter mybatisParameter = new TokuchoTaishoshaDoteiMybatisParameter();
        mybatisParameter.set処理年度(parameter.get処理年度());
        return new BatchDbReader(ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        doteiTempTableWriter
                = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                        DoteiTempEntity.class);
        介護徴収方法tableWriter
                = new BatchPermanentTableWriter(DbT2001ChoshuHohoEntity.class);
    }

    @Override
    protected void beforeExecute() {
        徴収種類 = get徴収種類(parameter.get開始月());
        mapper = getMapper(ITokuchoTaishoshaDoteiMapper.class);
        特別徴収義務者コードList = mapper.get特別徴収義務者コード(
                new TokubetsuChoshuGimushaGroupCode(地方公務員共済組合連合会));
    }

    @Override
    protected void process(TokuchoTaishoshaDoteiCombineEntity entity) {
        ChoshuHoho 徴収方法 = get徴収方法(entity.getDoteitemp());
        DbV2001ChoshuHohoEntity 最新徴収方法Entity = build介護徴収方法(entity.getChoshuhoho(), entity.getDoteitemp(),
                徴収種類, 徴収方法.getコード(), parameter.get開始月());
        最新徴収方法Entity.setRirekiNo(最新徴収方法Entity.getRirekiNo() + 1);
        最新徴収方法Entity.setIraiSohuzumiFlag(false);
        最新徴収方法Entity.setTsuikaIraiSohuzumiFlag(false);
        最新徴収方法Entity.setTokuchoTeishiNichiji(null);
        最新徴収方法Entity.setTokuchoTeishiJiyuCode(null);
        DbT2001ChoshuHohoEntity 徴収方法Entity = transDbV2001ToDbT2001(最新徴収方法Entity);
        徴収方法Entity.setState(EntityDataState.Added);
        if (null != 徴収方法Entity.getFukaNendo()) {
            介護徴収方法tableWriter.insert(徴収方法Entity);
        }
    }

    @Override
    protected void afterExecute() {
        RString 開始月 = parameter.get開始月();
        RString 年度内連番 = null;
        if (開始月_08.equals(開始月)) {
            年度内連番 = 年度内連番_0001;
        } else if (開始月_10.equals(開始月)) {
            年度内連番 = 年度内連番_0002;
        } else if (開始月_12.equals(開始月)) {
            年度内連番 = 年度内連番_0003;
        } else if (開始月_02.equals(開始月)) {
            年度内連番 = 年度内連番_0004;
        } else if (開始月_04.equals(開始月)) {
            年度内連番 = 年度内連番_0005;
        } else if (開始月_06.equals(開始月)) {
            年度内連番 = 年度内連番_0006;
        }

        TokuchoTaishoshaDoteiMybatisParameter mybatisParameter = new TokuchoTaishoshaDoteiMybatisParameter();
        mybatisParameter.setサーブ業務コード(SubGyomuCode.DBB介護賦課);
        mybatisParameter.set処理名(ShoriName.特徴対象者同定.get名称());
        mybatisParameter.set処理年度(parameter.get処理年度());
        mybatisParameter.set年度内連番(年度内連番);
        mybatisParameter.set処理日時(YMDHMS.now());
        getMapper(ITokuchoTaishoshaDoteiMapper.class).update処理日付管理マスタ(mybatisParameter);
    }

    private RString get徴収種類(RString 開始月) {
        if (開始月_08.equals(開始月)) {
            return 徴収種類_仮徴収;
        } else if (開始月_10.equals(開始月) || 開始月_12.equals(開始月) || 開始月_02.equals(開始月)) {
            return 徴収種類_本徴収;
        } else if (開始月_04.equals(開始月) || 開始月_06.equals(開始月)) {
            return 徴収種類_翌年度仮徴収;
        }
        return RString.EMPTY;
    }

    private ChoshuHoho get徴収方法(DoteiIchijiEntity 同定情報) {
        if (null != 特別徴収義務者コードList && !特別徴収義務者コードList.isEmpty()) {
            for (TokubetsuChoshuGimushaCode code : 特別徴収義務者コードList) {
                if (null != code && code.toRString().equals(同定情報.getDtTokubetsuChoshuGimushaCode())) {
                    return ChoshuHoho.特別徴収_地共済;
                }
            }
        }
        return ChoshuHoho.特別徴収_厚生労働省;

    }

    private DbV2001ChoshuHohoEntity build介護徴収方法(DbV2001ChoshuHohoEntity 徴収方法Entity,
            DoteiIchijiEntity 同定情報temp, RString 徴収種類, RString 徴収方法, RString 開始月) {
        if (徴収種類_仮徴収.equals(徴収種類)) {
            徴収方法Entity.setChoshuHoho8gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho9gatsu(徴収方法);
            徴収方法Entity.setKariNenkinNo(同定情報temp.getDtKisoNenkinNo());
            徴収方法Entity.setKariNenkinCode(同定情報temp.getDtNenkinCode());
            徴収方法Entity.setKariHosokuM(同定情報temp.getHosokuTsuki());
        } else if (徴収種類_本徴収.equals(徴収種類)) {
            if (開始月_10.equals(開始月)) {
                徴収方法Entity.setChoshuHoho10gatsu(徴収方法);
                徴収方法Entity.setChoshuHoho11gatsu(徴収方法);
            }
            if (開始月_10.equals(開始月) || 開始月_12.equals(開始月)) {
                徴収方法Entity.setChoshuHoho12gatsu(徴収方法);
                徴収方法Entity.setChoshuHoho1gatsu(徴収方法);
            }
            徴収方法Entity.setChoshuHoho2gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho3gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku4gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku5gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku6gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku7gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku8gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku9gatsu(徴収方法);
            徴収方法Entity.setHonNenkinNo(同定情報temp.getDtKisoNenkinNo());
            徴収方法Entity.setHonNenkinCode(同定情報temp.getDtNenkinCode());
            徴収方法Entity.setHonHosokuM(同定情報temp.getHosokuTsuki());
        } else if (徴収種類_翌年度仮徴収.equals(徴収種類)) {
            if (開始月_04.equals(開始月)) {
                徴収方法Entity.setChoshuHoho4gatsu(徴収方法);
                徴収方法Entity.setChoshuHoho5gatsu(徴収方法);
            }
            徴収方法Entity.setChoshuHoho6gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho7gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho8gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho9gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho10gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho11gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho12gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho1gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho2gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho3gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku4gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku5gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku6gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku7gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku8gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku9gatsu(徴収方法);
            徴収方法Entity.setYokunendoKariNenkinNo(同定情報temp.getDtKisoNenkinNo());
            徴収方法Entity.setYokunendoKariNenkinCode(同定情報temp.getDtNenkinCode());
            徴収方法Entity.setYokunendoKariHosokuM(同定情報temp.getHosokuTsuki());
        }
        return 徴収方法Entity;
    }

    private DbT2001ChoshuHohoEntity transDbV2001ToDbT2001(DbV2001ChoshuHohoEntity 徴収方法Entity) {
        DbT2001ChoshuHohoEntity trans = new DbT2001ChoshuHohoEntity();
        trans.setChoshuHoho10gatsu(徴収方法Entity.getChoshuHoho10gatsu());
        trans.setChoshuHoho11gatsu(徴収方法Entity.getChoshuHoho11gatsu());
        trans.setChoshuHoho12gatsu(徴収方法Entity.getChoshuHoho12gatsu());
        trans.setChoshuHoho1gatsu(徴収方法Entity.getChoshuHoho1gatsu());
        trans.setChoshuHoho2gatsu(徴収方法Entity.getChoshuHoho2gatsu());
        trans.setChoshuHoho3gatsu(徴収方法Entity.getChoshuHoho3gatsu());
        trans.setChoshuHoho4gatsu(徴収方法Entity.getChoshuHoho4gatsu());
        trans.setChoshuHoho5gatsu(徴収方法Entity.getChoshuHoho5gatsu());
        trans.setChoshuHoho6gatsu(徴収方法Entity.getChoshuHoho6gatsu());
        trans.setChoshuHoho7gatsu(徴収方法Entity.getChoshuHoho7gatsu());
        trans.setChoshuHoho8gatsu(徴収方法Entity.getChoshuHoho8gatsu());
        trans.setChoshuHoho9gatsu(徴収方法Entity.getChoshuHoho9gatsu());
        trans.setChoshuHohoYoku4gatsu(徴収方法Entity.getChoshuHohoYoku4gatsu());
        trans.setChoshuHohoYoku5gatsu(徴収方法Entity.getChoshuHohoYoku5gatsu());
        trans.setChoshuHohoYoku6gatsu(徴収方法Entity.getChoshuHohoYoku6gatsu());
        trans.setChoshuHohoYoku7gatsu(徴収方法Entity.getChoshuHohoYoku7gatsu());
        trans.setChoshuHohoYoku8gatsu(徴収方法Entity.getChoshuHohoYoku8gatsu());
        trans.setChoshuHohoYoku9gatsu(徴収方法Entity.getChoshuHohoYoku9gatsu());
        FlexibleYear year = 徴収方法Entity.getFukaNendo();
        if (null != year) {
            trans.setFukaNendo(year);
        }
        HihokenshaNo hihokenshaNo = 徴収方法Entity.getHihokenshaNo();
        if (null != hihokenshaNo) {
            trans.setHihokenshaNo(hihokenshaNo);
        }
        trans.setHonHosokuM(徴収方法Entity.getHonHosokuM());
        trans.setHonNenkinCode(徴収方法Entity.getHonNenkinCode());
        trans.setHonNenkinNo(徴収方法Entity.getHonNenkinNo());
        trans.setInsertDantaiCd(徴収方法Entity.getInsertDantaiCd());
        trans.setIraiSohuzumiFlag(徴収方法Entity.getIraiSohuzumiFlag());
        trans.setIsDeleted(徴収方法Entity.getIsDeleted());
        trans.setKariHosokuM(徴収方法Entity.getKariHosokuM());
        trans.setKariNenkinCode(徴収方法Entity.getKariNenkinCode());
        trans.setKariNenkinNo(徴収方法Entity.getKariNenkinNo());
        trans.setRirekiNo(徴収方法Entity.getRirekiNo());
        trans.setTokuchoTeishiJiyuCode(徴収方法Entity.getTokuchoTeishiJiyuCode());
        trans.setTokuchoTeishiNichiji(徴収方法Entity.getTokuchoTeishiNichiji());
        trans.setTsuikaIraiSohuzumiFlag(徴収方法Entity.getTsuikaIraiSohuzumiFlag());
        trans.setYokunendoKariHosokuM(徴収方法Entity.getYokunendoKariHosokuM());
        trans.setYokunendoKariNenkinCode(徴収方法Entity.getYokunendoKariNenkinCode());
        trans.setYokunendoKariNenkinNo(徴収方法Entity.getYokunendoKariNenkinNo());
        return trans;
    }

}
