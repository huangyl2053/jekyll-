/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.DBC8010001;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 振込明細・振込みデータ作成を管理するクラスです。
 *
 * @reamsid_L DBC-2180-010 x_liuwei
 */
public class DBC8010001MainManager {

    private final DbT7022ShoriDateKanriDac dac;

    public DBC8010001MainManager() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     *
     * @param サブ業務コード
     * @param 市町村コード
     * @param 処理名
     * @param 処理枝番
     * @param 年度
     * @param 年度内連番
     * @return DbT7022ShoriDateKanriEntity
     */
    public DbT7022ShoriDateKanriEntity get前回処理情報(SubGyomuCode サブ業務コード, LasdecCode 市町村コード, RString 処理名, RString 処理枝番,
            FlexibleYear 年度, RString 年度内連番) {
        DbT7022ShoriDateKanriEntity entity = dac.selectByKey(サブ業務コード, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return entity;
    }

}
