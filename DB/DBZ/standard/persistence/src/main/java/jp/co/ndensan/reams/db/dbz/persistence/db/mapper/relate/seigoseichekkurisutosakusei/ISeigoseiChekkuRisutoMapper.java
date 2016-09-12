/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.seigoseichekkurisutosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.seigoseichekkurisutosakusei.SeigoseiChekkuMybitisParamter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1014SeigoseiCheckEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.seigoseichekkurisutosakusei.SeigoseiChekkuRisutoEntity;

/**
 * 整合性チェックリストのマッパーインタフェースです。
 *
 * @reamsid_L DBA-5800-030 zhangzhiming
 */
public interface ISeigoseiChekkuRisutoMapper {

    /**
     * 整合性チェックリストを取得します。
     *
     * @param paramter 整合性入力データパラメータ
     * @return 宛名の入力情報
     */
    List<SeigoseiChekkuRisutoEntity> get宛名入力情報(SeigoseiChekkuMybitisParamter paramter);

    /**
     * 整合性チェック情報を取得します。
     *
     * @return 整合性チェック情報
     */
    List<DbT1014SeigoseiCheckEntity> get整合性チェック情報();

    /**
     * 整合性チェック情報を削除します。
     *
     */
    void del整合性情報事前削除();

    /**
     * 整合性チェック情報を取得します。
     *
     * @return 整合性チェック情報
     */
    List<SeigoseiChekkuRisutoEntity> select整合性チェック情報();

    /**
     * 被保険者台帳情報を取得します。
     *
     * @param paramter 整合性入力データパラメータ
     * @return 被保険者台帳情報
     */
    List<SeigoseiChekkuRisutoEntity> get被保険者台帳情報(SeigoseiChekkuMybitisParamter paramter);

    /**
     * 被保険者台帳情報を削除します。
     *
     */
    void del被保険者台帳情報削除();

    /**
     * 被保険者台帳情報を取得します。
     *
     * @return 被保険者台帳情報
     */
    List<SeigoseiChekkuRisutoEntity> select被保険者台帳情報();
}
