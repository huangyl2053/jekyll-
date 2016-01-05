/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.idochecklist;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.IdoInfoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動チェックリスト情報クラスです
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoCheckListInfo implements Serializable {

    private static final long serialVersionUID = 3140268492979895420L;

    private LasdecCode 市町村コード;
    private RString 市町村名;
    private int 並び順１;
    private int 並び順２;
    private int 並び順３;
    private int 並び順４;
    private int 並び順５;

    private List<IdoInfoEntity> idoInfoList;

}
