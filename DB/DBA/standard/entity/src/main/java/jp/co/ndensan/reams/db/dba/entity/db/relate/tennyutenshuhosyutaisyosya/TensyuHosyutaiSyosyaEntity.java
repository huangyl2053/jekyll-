/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshuhosyutaisyosya;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 転出保留対象者RelateEntityクラスです。
 *
 * @reamsid_L DBU-4110-030 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TensyuHosyutaiSyosyaEntity {

    private RString 識別コード;
    private int 履歴番号;
    private RString 市町村コード;
    private RString 作成事由コード;
    private RString 世帯コード;
    private RString 住民種別コード;
    private RString 住民状態コード;
    private RString 宛名氏名;
    private RString 宛名カナ氏名;
    private RString 生年月日;
    private RString 性別コード;
    private RString 異動事由コード;
    private RString 登録異動年月日;
    private RString 登録異動届出年月日;
    private RString 消除異動年月日;
    private RString 消除異動届出年月日;
    private RString 転出予定異動年月日;
    private RString 転出確定異動年月日;
    private RString 転出確定異動通知年月日;
    private RString 全国住所コード;
    private RString 住所;
    private RString 番地;
    private RString 方書;
    private RString 転出予定全国住所コード;
    private RString 転出予定住所;
    private RString 転出予定番地;
    private RString 転出予定方書;
    private RString 転出確定全国住所コード;
    private RString 転出確定住所;
    private RString 転出確定番地;
    private RString 転出確定方書;
    private RString 住所地特例フラグ;
}
