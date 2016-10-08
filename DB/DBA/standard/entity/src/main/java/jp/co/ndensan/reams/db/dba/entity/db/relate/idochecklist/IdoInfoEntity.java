/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動情報のエンティティクラスです。
 *
 * @reamsid_L DBA-0530-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoInfoEntity implements Serializable {

    private static final long serialVersionUID = 1485714239788816364L;

    private SetaiCode 世帯コード;
    private AtenaMeisho 被保険者氏名;
    private AtenaKanaMeisho 被保険者カナ氏名;
    private int 対象情報;
    private RString 改頁１;
    private RString 改頁２;
    private RString 改頁３;
    private RString 改頁４;
    private RString 改頁５;
    private RString 対象情報タイトル;
    private RString 開始タイトル;
    private RString 終了タイトル;
    private RString 区分タイトル;
    private RString 異動情報タイトル1;
    private RString 異動情報タイトル2;
    private RString 異動情報タイトル3;
    private RString 開始年月日タイトル;
    private RString 終了年月日タイトル;
    private RString 異動情報タイトル4;
    private RString 異動情報タイトル5;
    private RString 異動情報タイトル6;
    private FlexibleDate 開始年月日データ_前;
    private FlexibleDate 終了年月日データ_前;
    private FlexibleDate 開始年月日データ_後;
    private FlexibleDate 終了年月日データ_後;
    private RString 異動情報データ1;
    private RString 異動情報データ2;
    private RString 異動情報データ3;
    private RString 異動情報データ4;
    private RString 異動情報データ5;
    private RString 異動情報データ6;
    private RString 被保険者番号;
    private ShikibetsuCode 識別コード;
    private RString 取得情報_前_事由;
    private FlexibleDate 取得情報_前_異動年月日;
    private FlexibleDate 取得情報_前_届出年月日;
    private RString 喪失情報_前_事由;
    private FlexibleDate 喪失情報_前_異動年月日;
    private FlexibleDate 喪失情報_前_届出年月日;
    private RString 取得情報_後_事由;
    private FlexibleDate 取得情報_後_異動年月日;
    private FlexibleDate 取得情報_後_届出年月日;
    private RString 喪失情報_後_事由;
    private FlexibleDate 喪失情報_後_異動年月日;
    private FlexibleDate 喪失情報_後_届出年月日;
    private RString 区分_前_資格;
    private RString 区分_後_資格;
    
}
