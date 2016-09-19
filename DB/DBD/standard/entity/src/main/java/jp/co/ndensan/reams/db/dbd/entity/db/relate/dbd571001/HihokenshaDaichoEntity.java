/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBD571001_受給者台帳を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDaichoEntity {

    private HihokenshaNo 資格情報_被保険者番号;
    private FlexibleDate 資格情報_異動日;
    private RString 資格情報_枝番;
    private FlexibleDate 資格情報_資格取得年月日;
    private FlexibleDate 資格情報_資格取得届出年月日;
    private RString 資格情報_資格取得事由コード;
    private FlexibleDate 資格情報_資格喪失年月日;
    private FlexibleDate 資格情報_資格喪失届出年月日;
    private RString 資格情報_資格喪失事由コード;
    private FlexibleDate 資格情報_資格変更年月日;
    private FlexibleDate 資格情報_資格変更届出年月日;
    private RString 資格情報_資格変更事由コード;
    private FlexibleDate 資格情報_適用年月日;
    private FlexibleDate 資格情報_適用届出年月日;
    private RString 資格情報_住所地特例適用事由コード;
    private FlexibleDate 資格情報_解除年月日;
    private FlexibleDate 資格情報_解除届出年月日;
    private RString 資格情報_住所地特例解除事由コード;
}
