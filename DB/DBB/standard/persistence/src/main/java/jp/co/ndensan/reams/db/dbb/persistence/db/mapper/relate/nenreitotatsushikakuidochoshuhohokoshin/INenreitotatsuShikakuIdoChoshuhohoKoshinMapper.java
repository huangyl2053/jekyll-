/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nenreitotatsushikakuidochoshuhohokoshin;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nenreitotatsushikakuidochoshuhohokoshin.NenreitotatsuShikakuIdoChoshuhohoKoshinMybatisParam;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * ６５歳年齢到達資格異動徴収方法更新 Mapper
 *
 * @reamsid_L DBB-9210-010 xuhao
 *
 */
public interface INenreitotatsuShikakuIdoChoshuhohoKoshinMapper {

    /**
     * select被保険者番号
     *
     * @param param NenreitotatsuShikakuIdoChoshuhohoKoshinMybatisParam
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    List<DbT1001HihokenshaDaichoEntity> selectHihokenjabango(NenreitotatsuShikakuIdoChoshuhohoKoshinMybatisParam param);
}
