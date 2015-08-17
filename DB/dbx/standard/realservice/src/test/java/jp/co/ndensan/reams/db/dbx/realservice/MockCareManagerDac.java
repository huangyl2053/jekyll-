/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.db.dbx.persistence.basic.IDbT7064CareManegerDac;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link CareManagerDac}のモックです。
 *
 * @author n9944 趙 春暉
 */
public class MockCareManagerDac implements IDbT7064CareManegerDac {

    @Override
    public DbT7064CareManegerEntity selectByNumber(RString 介護支援専門員番号) {
        return null;
    }

    @Override
    public List<DbT7064CareManegerEntity> selectByJigyoshaCode(KaigoJigyoshaNo 介護事業者番号) {
        return Collections.EMPTY_LIST;
    }
}
