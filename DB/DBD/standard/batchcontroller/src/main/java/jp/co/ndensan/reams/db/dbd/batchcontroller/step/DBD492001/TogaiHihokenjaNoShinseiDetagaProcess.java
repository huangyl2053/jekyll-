/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ErrorRecord;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.HenKouData;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.TogaiHihokenjaNoShinseiDetagaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 当該被保険者の申請データが存在するかどうかチェック_process処理クラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class TogaiHihokenjaNoShinseiDetagaProcess extends BatchProcessBase<TogaiHihokenjaNoShinseiDetagaEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "yokaigoninteikekkarenkeidetatorikomi.ITogaiHihokenjaNoShinseiDetagaMapper.get当該被保険者の申請データが存在");

    private List<ErrorRecord> errorRecordList;
    private HenKouData entity;
    private ErrorRecord error;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void initialize() {
        errorRecordList = new ArrayList<>();
    }

    @Override
    protected void process(TogaiHihokenjaNoShinseiDetagaEntity t) {
        if (t.getShinseishoKanriNo() == null) {
            error.setShikibetsukodo(entity.get識別コード());
            error.setHokenshabango(entity.get保険者番号());
            error.setHihokenjabango(entity.get被保険者番号());
            error.setNinteishinseibi(entity.get認定申請日());
            error.setEdaban(entity.get枝番());
            error.setShinseikubunhorei(entity.get申請区分_法令コード());
            error.setShinseikubunshinseiji(entity.get申請区分_申請時コード());
            error.setTorisakubunkodo(entity.get取下区分コード());
            error.setHihokenjakubun(entity.get被保険者区分コード());
            error.setShinseidaikokubun(entity.get申請代行区分コード());
            error.setSeinengappi(entity.get生年月日());
            error.setNenrei(entity.get年齢());
            error.setSeibetsukodo(entity.get性別コード());
            error.setHihokenjakanashimei(entity.get被保険者ｶﾅ氏名());
            error.setHihokenjakanjishimei(entity.get被保険者漢字氏名());
            error.setYubenbango(entity.get郵便番号());
            error.setJusho(entity.get住所());
            error.setTenwabango(entity.get電話番号());
            error.setByoinshisetsutonomeisho(entity.get病院施設等の名称());
            error.setByoinshisetsutonoshozaichi(entity.get病院施設等の所在地());
            errorRecordList.add(error);
        }
    }
}
