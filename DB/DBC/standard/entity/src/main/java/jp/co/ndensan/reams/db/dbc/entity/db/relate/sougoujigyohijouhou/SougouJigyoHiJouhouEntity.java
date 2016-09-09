/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sougoujigyohijouhou;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(総合事業費情報)のEntityクラスです。
 *
 * @reamsid_L DBC-3107-010 wanghuafeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SougouJigyoHiJouhouEntity {

    private RString サービス種類コード;
    private RString サービス種類名称;
    private RString サービス種類コード_最新;
}
