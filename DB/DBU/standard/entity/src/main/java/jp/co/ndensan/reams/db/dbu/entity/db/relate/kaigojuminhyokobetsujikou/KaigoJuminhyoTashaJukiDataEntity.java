/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsujikou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護住民票個別事項連携情報のエンティティクラスです。
 *
 * @reamsid_L DBU-0350-030 zhengshukai
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoJuminhyoTashaJukiDataEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleDate 異動日;
    private RString 枝番;
    private RString 異動事由コード;
    private RString 市町村コード;
    private ShikibetsuCode 識別コード;
    private RString 資格取得事由コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格取得届出年月日;
    private FlexibleDate 第1号資格取得年月日;
    private RString 被保険者区分コード;
    private RString 資格喪失事由コード;
    private FlexibleDate 資格喪失年月日;
    private FlexibleDate 資格喪失届出年月日;
    private RString 資格変更事由コード;
    private FlexibleDate 資格変更年月日;
    private FlexibleDate 資格変更届出年月日;
    private RString 住所地特例適用事由コード;
    private FlexibleDate 適用年月日;
    private FlexibleDate 適用届出年月日;
    private RString 住所地特例解除事由コード;
    private FlexibleDate 解除年月日;
    private FlexibleDate 解除届出年月日;
    private RString 住所地特例フラグ;
    private RString 広域内住所地特例フラグ;
    private LasdecCode 広住特措置元市町村コード;
    private LasdecCode 旧市町村コード;
    private boolean 論理削除フラグ;
    private RString 挿入日時;
    private RString 更新日時;
    private LasdecCode 受給者市町村コード;
    private HihokenshaNo 受給者被保険者番号;
    private RString 受給者履歴番号;
    private RString 受給者枝番;
    private ShinseishoKanriNo 受給者申請書管理番号;
    private RString 受給者申請状況区分;
    private RString 受給者支所コード;
    private boolean 受給者直近フラグ;
    private ShikibetsuCode 受給者識別コード;
    private Code 受給者受給申請事由;
    private RString 受給者申請理由;
    private Code 受給者届出者申請者関係コード;
    private RString 受給者届出者本人との関係;
    private FlexibleDate 受給者受給申請年月日;
    private Code 受給者２号特定疾病コード;
    private FlexibleDate 受給者審査会依頼年月日;
    private Code 受給者要介護認定状態区分コード;
    private FlexibleDate 受給者認定有効期間開始年月日;
    private FlexibleDate 受給者認定有効期間終了年月日;
    private FlexibleDate 受給者認定年月日;
    private ServiceShuruiCode 受給者指定サービス種類01;
    private ServiceShuruiCode 受給者指定サービス種類02;
    private ServiceShuruiCode 受給者指定サービス種類03;
    private ServiceShuruiCode 受給者指定サービス種類04;
    private ServiceShuruiCode 受給者指定サービス種類05;
    private ServiceShuruiCode 受給者指定サービス種類06;
    private ServiceShuruiCode 受給者指定サービス種類07;
    private ServiceShuruiCode 受給者指定サービス種類08;
    private ServiceShuruiCode 受給者指定サービス種類09;
    private ServiceShuruiCode 受給者指定サービス種類10;
    private ServiceShuruiCode 受給者指定サービス種類11;
    private ServiceShuruiCode 受給者指定サービス種類12;
    private ServiceShuruiCode 受給者指定サービス種類13;
    private ServiceShuruiCode 受給者指定サービス種類14;
    private ServiceShuruiCode 受給者指定サービス種類15;
    private ServiceShuruiCode 受給者指定サービス種類16;
    private ServiceShuruiCode 受給者指定サービス種類17;
    private ServiceShuruiCode 受給者指定サービス種類18;
    private ServiceShuruiCode 受給者指定サービス種類19;
    private ServiceShuruiCode 受給者指定サービス種類20;
    private ServiceShuruiCode 受給者指定サービス種類21;
    private ServiceShuruiCode 受給者指定サービス種類22;
    private ServiceShuruiCode 受給者指定サービス種類23;
    private ServiceShuruiCode 受給者指定サービス種類24;
    private ServiceShuruiCode 受給者指定サービス種類25;
    private ServiceShuruiCode 受給者指定サービス種類26;
    private ServiceShuruiCode 受給者指定サービス種類27;
    private ServiceShuruiCode 受給者指定サービス種類28;
    private ServiceShuruiCode 受給者指定サービス種類29;
    private ServiceShuruiCode 受給者指定サービス種類30;
    private FlexibleDate 受給者喪失年月日;
    private FlexibleDate 受給者直近異動年月日;
    private Code 受給者直近異動事由コード;
    private Code 受給者有効無効区分;
    private Code 受給者データ区分;
    private RString 受給者同一連番;
    private RString 受給者異動理由;
    private Code 受給者申請書区分;
    private Code 受給者削除事由コード;
    private boolean 受給者要支援者認定申請区分;
    private Decimal 受給者支給限度単位数;
    private FlexibleDate 受給者支給限度有効開始年月日;
    private FlexibleDate 受給者支給限度有効終了年月日;
    private int 受給者短期入所支給限度日数;
    private FlexibleDate 受給者短期入所支給限度開始年月日;
    private FlexibleDate 受給者短期入所支給限度終了年月日;
    private FlexibleDate 受給者当初認定有効開始年月日;
    private FlexibleDate 受給者当初認定有効終了年月日;
    private FlexibleDate 受給者受給資格証明書発行年月日１;
    private FlexibleDate 受給者受給資格証明書発行年月日２;
    private FlexibleDate 受給者診断命令書発行年月日;
    private FlexibleDate 受給者２号申請受理通知書発行年月日;
    private FlexibleDate 受給者認定結果通知書発行年月日;
    private FlexibleDate 受給者区分変更通知書発行年月日;
    private FlexibleDate 受給者サービス変更通知書発行年月日;
    private FlexibleDate 受給者認定却下通知書発行年月日;
    private FlexibleDate 受給者認定取消通知書発行年月日;
    private boolean 受給者資格取得前申請フラグ;
    private boolean 受給者旧措置者フラグ;
    private boolean 受給者論理削除フラグ;
    private RString 受給者挿入日時;
    private RString 受給者更新日時;
}
