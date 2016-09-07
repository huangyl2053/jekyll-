/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.postmainpanel;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBC0510011_国保・後期高齢資格異動情報取込
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PostMainPanelEntity {

    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private RString 市町村識別ID;
    private YMDHMS 基準日時;
    private YMDHMS 対象開始日時;
}
