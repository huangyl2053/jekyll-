/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.UpdShoriDateKanriProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理テーブル更新します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class SelShoriDateKanriProcess extends SimpleBatchProcessBase {

    private static final RString 年度内連番_0001 = new RString("0001");
    private static final RString 年度内連番_0002 = new RString("0002");
    private static final RString 年度内連番_0003 = new RString("0003");
    private static final RString 年度内連番_0005 = new RString("0005");
    private static final RString 年度内連番_0006 = new RString("0006");
    private static final RString 年度内連番_0007 = new RString("0007");
    private static final RString 年度内連番_0008 = new RString("0008");
    private static final RString 年度内連番_0009 = new RString("0009");
    private static final RString 年度内連番_0010 = new RString("0010");
    private static final RString 年度内連番_0011 = new RString("0011");
    private static final RString 年度内連番_0012 = new RString("0012");

    private ITokuChoSoufuJohoSakuseiBatchMapper mapper;
    private UpdShoriDateKanriProcessParameter parameter;

    /**
     * OutputParameter用キー kijunTime
     */
    public static final RString KIJUN_TIME;

    static {
        KIJUN_TIME = new RString("kijunTime");
    }
    private OutputParameter<RString> kijunTime;
    YMDHMS 最新調定日時;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(ITokuChoSoufuJohoSakuseiBatchMapper.class);
        kijunTime = new OutputParameter<>();
    }

    @Override
    protected void process() {
        RString 処理名;
        RString 年度内連番;
        if (parameter.is処理対象月が7月()) {
            処理名 = ShoriName.特徴依頼情報作成.get名称();
            年度内連番 = 年度内連番_0001;
        } else {
            処理名 = ShoriName.特徴異動情報作成.get名称();
            年度内連番 = get年度内連番();
        }
        最新調定日時 = mapper.get基準日時(parameter.toUpdateTableMyBatisParameter(処理名, 年度内連番));
    }

    @Override
    protected void afterExecute() {
        if (最新調定日時 != null) {
            kijunTime.setValue(最新調定日時.toDateString());
        } else {
            kijunTime.setValue(RString.EMPTY);
        }
    }

    private RString get年度内連番() {
        if (parameter.is処理対象月が4月()) {
            return 年度内連番_0001;
        } else if (parameter.is処理対象月が5月()) {
            return 年度内連番_0002;
        } else if (parameter.is処理対象月が6月()) {
            return 年度内連番_0003;
        } else if (parameter.is処理対象月が8月()) {
            return 年度内連番_0005;
        } else if (parameter.is処理対象月が9月()) {
            return 年度内連番_0006;
        } else if (parameter.is処理対象月が10月()) {
            return 年度内連番_0007;
        } else if (parameter.is処理対象月が11月()) {
            return 年度内連番_0008;
        } else if (parameter.is処理対象月が12月()) {
            return 年度内連番_0009;
        } else if (parameter.is処理対象月が1月()) {
            return 年度内連番_0010;
        } else if (parameter.is処理対象月が2月()) {
            return 年度内連番_0011;
        } else if (parameter.is処理対象月が3月()) {
            return 年度内連番_0012;
        }
        return RString.EMPTY;
    }
}
