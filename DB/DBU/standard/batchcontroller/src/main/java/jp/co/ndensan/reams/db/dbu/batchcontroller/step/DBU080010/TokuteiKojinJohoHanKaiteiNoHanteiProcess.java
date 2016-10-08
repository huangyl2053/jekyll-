/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShokaiTeikyoKubun;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo.ITokuteiKojinJohoTeikyoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 版改定の判定のバッチ処理です。
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
public class TokuteiKojinJohoHanKaiteiNoHanteiProcess extends SimpleBatchProcessBase {

    /**
     * データ有無の判定です。
     */
    public static final RString TOKUTEIKOJINJOHOHANKANRICOUNT;

    static {
        TOKUTEIKOJINJOHOHANKANRICOUNT = new RString("tokuteiKojinJohoHanKanriCount");
    }
    private OutputParameter<Integer> tokuteiKojinJohoHanKanriCount;

    @Override
    protected void process() {
        tokuteiKojinJohoHanKanriCount = new OutputParameter<>();
        tokuteiKojinJohoHanKanriCount.setValue(getMapper(ITokuteiKojinJohoTeikyoMapper.class)
                .getTokuteiKojinJohoHanKanriCount(ShokaiTeikyoKubun.初回提供済み.getコード()));
    }

}
