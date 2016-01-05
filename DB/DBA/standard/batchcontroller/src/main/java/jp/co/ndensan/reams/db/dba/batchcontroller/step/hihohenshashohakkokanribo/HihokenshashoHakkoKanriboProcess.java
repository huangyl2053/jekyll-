/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.hihohenshashohakkokanribo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakkokanribochohyodatasakusei.HihohenshashoHakkoKanriboChohyoDataSakusei;
import jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakokanribocsvdatasakusei.HihohenshashoHakoKanriboCsvDataSakusei;
import jp.co.ndensan.reams.db.dba.definition.processprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者証発行管理簿_バッチフ処理クラスです
 */
public class HihokenshashoHakkoKanriboProcess extends BatchProcessBase<AkasiHakouKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.hihokenshashohakkokanribo.IHihokenshashoHakkoKanriboMapper.get証発行管理リスト情報");
    private HihokenshashoHakkoKanriboProcessParameter processParameter;
    private List<HihohenshashoHakkoKanriboChohyoDataSakusei> hihohenshashoHakkoKanriboChohyoDataSakuseiList;
    private List<HihohenshashoHakoKanriboCsvDataSakusei> hihohenshashoHakoKanriboCsvDataSakuseiList;

    @Override
    protected void initialize() {
        hihohenshashoHakkoKanriboChohyoDataSakuseiList = new ArrayList<>();
        hihohenshashoHakoKanriboCsvDataSakuseiList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {

    }

    @Override
    protected void process(AkasiHakouKanriEntity entity) {
        HihohenshashoHakoKanriboCsvDataSakusei hihohenshashoHakoKanriboCsvDataSakusei = HihohenshashoHakoKanriboCsvDataSakusei
                .createParam_ShohakkoKanriCSVDataList(
                        entity.getHihokenshaNo(),
                        MYBATIS_SELECT_ID,
                        YubinNo.EMPTY,
                        MYBATIS_SELECT_ID,
                        MYBATIS_SELECT_ID,
                        LasdecCode.EMPTY,
                        FlexibleDate.MAX,
                        Code.EMPTY,
                        MYBATIS_SELECT_ID,
                        MYBATIS_SELECT_ID,
                        FlexibleDate.MAX,
                        Code.EMPTY,
                        MYBATIS_SELECT_ID,
                        FlexibleDate.MAX,
                        MYBATIS_SELECT_ID,
                        true,
                        true);
        hihohenshashoHakoKanriboCsvDataSakuseiList.add(hihohenshashoHakoKanriboCsvDataSakusei);
    }

    @Override
    protected void afterExecute() {

    }
}
