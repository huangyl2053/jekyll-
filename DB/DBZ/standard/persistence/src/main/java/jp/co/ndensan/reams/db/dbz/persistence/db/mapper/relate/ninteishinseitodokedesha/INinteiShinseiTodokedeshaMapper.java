/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteishinseitodokedesha;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteishinseitodokedesha.NinteiShinseiTodokedeshaMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteishinseitodokedesha.NinteiShinseiTodokedeshaEntity;

/**
 * 介護認定申請届出者のマッパーインタフェースです。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
public interface INinteiShinseiTodokedeshaMapper {

    /**
     * 介護資格基本情報を識別コード検索でリスト取得します。
     *
     * @param parameter NinteiShinseiTodokedeshaMybatisParameter
     * @return NinteiShinseiTodokedeshaEntity
     */
    List<NinteiShinseiTodokedeshaEntity> select宛名データOnly_宛名条件And業務条件(NinteiShinseiTodokedeshaMybatisParameter parameter);
}
