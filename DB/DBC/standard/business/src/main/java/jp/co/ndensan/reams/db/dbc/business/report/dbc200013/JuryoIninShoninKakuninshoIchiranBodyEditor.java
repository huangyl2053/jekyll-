/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200013;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200013.JuryoIninShoninKakuninshoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200013.JuryoIninShoninKakuninshoIchiranSource;

/**
 * 帳票設計_DBCMN32002_受領委任契約承認確認書発行一覧表BodyEditor
 *
 * @reamsid_L DBC-1910-070 jiangxiaolong
 */
public class JuryoIninShoninKakuninshoIchiranBodyEditor
        implements IJuryoIninShoninKakuninshoIchiranEditor {

    private final JuryoIninShoninKakuninshoIchiranEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity JuryoIninShoninKakuninshoIchiranEntity
     */
    public JuryoIninShoninKakuninshoIchiranBodyEditor(
            JuryoIninShoninKakuninshoIchiranEntity entity) {
        this.entity = entity;
    }

    @Override
    public JuryoIninShoninKakuninshoIchiranSource edit(
            JuryoIninShoninKakuninshoIchiranSource source) {
        if (null == entity) {
            return source;
        }
        edit明細(source);
        return source;
    }

    private void edit明細(JuryoIninShoninKakuninshoIchiranSource source) {
        source.ListUpper_1 = entity.get連番();
        source.ListUpper_2 = entity.get被保険者番号();
        source.ListUpper_3 = entity.get被保険者氏名1();
        source.ListUpper_4 = entity.get事業者所在地();
        source.ListUpper_5 = entity.get受付日();
        source.ListUpper_6 = entity.get承認開始日();
        source.ListUpper_7 = entity.get承認終了日();
        source.ListUpper_8 = entity.get承認終区分();
        source.ListLower_1 = entity.get被保険者氏名2();
        source.ListLower_2 = entity.get事業者名称();
        source.ListLower_3 = entity.get承認日();
        source.ListLower_4 = entity.get利用サービス内容();
    }

}
