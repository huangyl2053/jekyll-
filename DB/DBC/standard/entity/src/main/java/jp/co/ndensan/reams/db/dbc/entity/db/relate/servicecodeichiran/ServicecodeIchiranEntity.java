/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecodeichiran;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;

/**
 * バッチ設計_DBCMNJ2006_サービスコード一覧表のEntityのクラス
 *
 * @reamsid_L DBC-3310-030 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServicecodeIchiranEntity implements Serializable {

    private DbT7131KaigoServiceNaiyouEntity 介護サービス内容;
}
