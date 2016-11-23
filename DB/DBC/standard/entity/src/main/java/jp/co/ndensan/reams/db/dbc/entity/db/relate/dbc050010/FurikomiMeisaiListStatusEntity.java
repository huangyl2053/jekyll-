/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import lombok.Getter;
import lombok.Setter;

/**
 * 振込明細一覧表作成_受給取得状況データ取得SQL結果クラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomiMeisaiListStatusEntity {

    private FurikomiDetailTempTableEntity 振込明細一時Entity;
    private DbT4001JukyushaDaichoEntity 受給者台帳Entity;
    private Code 認定申請区分申請時コード;
}
