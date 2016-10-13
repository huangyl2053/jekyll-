/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年齢到達登録者リストEntity。
 *
 * @reamsid_L DBA-0570-020 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreiTotatsuTorokushaListEntity {

    private LasdecCode 市町村コード;
    private RString 市町村名;
    private RString 並び順_1;
    private RString 並び順_2;
    private RString 並び順_3;
    private RString 並び順_4;
    private RString 並び順_5;
    private RString 改頁１;
    private RString 改頁２;
    private RString 改頁３;
    private RString 改頁４;
    private RString 改頁５;
    private List<NenreiTotatsushaJouhouEntity> 年齢到達者情報;
    private RString 抽出期間From;
    private RString 抽出期間To;
}
