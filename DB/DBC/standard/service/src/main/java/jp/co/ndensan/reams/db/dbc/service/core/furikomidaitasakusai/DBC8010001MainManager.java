/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.furikomidaitasakusai;

import jp.co.ndensan.reams.db.dbc.business.core.dbc8010001.DBC8010001;
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

    /**
     * コンストラクタです。
     */
    public DBC8010001MainManager() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード LasdecCode
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @param 年度 FlexibleYear
     * @param 年度内連番 RString
     * @return DbT7022ShoriDateKanriEntity
     */
    public DBC8010001 get前回処理情報(SubGyomuCode サブ業務コード, LasdecCode 市町村コード, RString 処理名, RString 処理枝番,
            FlexibleYear 年度, RString 年度内連番) {

        DbT7022ShoriDateKanriEntity entity = dac.selectByKey(サブ業務コード, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番);
        if (null == entity) {
            return null;
        }
        entity.initializeMd5();

        return new DBC8010001(entity);
    }

}
