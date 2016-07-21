/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutokokikoreisha;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(後期高齢者)のRelateEntityクラスです。
 *
 * @reamsid_L DBD-5520-030 mawy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoRisutoKokiKoreishaEntity {

    private RString 被保険者台帳管理_被保険者番号;
    private RString 被保険者台帳管理_資格取得事由コード;
    private FlexibleDate 被保険者台帳管理_資格取得年月日;
    private FlexibleDate 被保険者台帳管理_資格取得届出年月日;
    private RString 被保険者台帳管理_資格喪失事由コード;
    private FlexibleDate 被保険者台帳管理_資格喪失年月日;
    private FlexibleDate 被保険者台帳管理_資格喪失届出年月日;
    private RString 被保険者台帳管理_被保険者区分コード;
    private RString 被保険者台帳管理_住所地特例フラグ;
    private RString 被保険者台帳管理_広域内住所地特例フラグ;
    private RString 被保険者台帳管理_広住特措置元市町村コード;
    private RString 被保険者台帳管理_市町村コード;
    private RString 医療保険加入状況_医療保険種別コード;
    private RString 医療保険加入状況_医療保険者番号;
    private RString 医療保険加入状況_医療保険者名称;
    private RString 医療保険加入状況_医療保険記号番号;
    private RString 受給者台帳_2号特定疾病コード;
    private RString 受給者台帳_受給申請事由;
    private RString 受給者台帳_要支援者認定申請区分;
    private RString 受給者台帳_申請理由;
    private RString 受給者台帳_申請者関係コード;
    private RString 受給者台帳_本人との関係;
    private RString 今回申請届出_申請届出者氏名;
    private RString 今回申請届出_申請届出者氏名カナ;
    private RString 申請届出事業者_事業者名称;
    private RString 申請届出事業者_事業者名称カナ;
    private RString 今回申請届出_申請届出者郵便番号;
    private RString 今回申請届出_申請届出者住所;
    private RString 今回申請届出_申請届出者電話番号;
    private RString 今回申請届出_申請届出代行事業者番号;
    private FlexibleDate 受給者台帳_受給申請年月日;
    private RString 今回申請_認定調査委託先コード;
    private RString 今回申請_認定調査員コード;
    private RString 今回調査委託先_事業者名称;
    private RString 今回調査委託先_事業者名称カナ;
    private RString 今回調査委託先_代表者名;
    private RString 今回調査委託先_代表者名カナ;
    private RString 今回調査委託先_郵便番号;
    private RString 今回調査委託先_住所;
    private RString 今回調査委託先_電話番号;
    private boolean 今回調査委託先_状況フラグ;
    private RString 今回調査員_調査員氏名;
    private RString 今回調査員_調査員氏名カナ;
    private RString 今回調査員_性別;
    private RString 今回調査員_郵便番号;
    private RString 今回調査員_住所;
    private RString 今回調査員_電話番号;
    private RString 今回調査員_調査員資格;
    private RString 今回調査員_所属機関名称;
    private boolean 今回調査員_状況フラグ;
    private RString 今回申請_主治医医療機関コード;
    private RString 今回申請_主治医コード;
    private RString 今回主治医医療機関_医療機関名称;
    private RString 今回主治医医療機関_医療機関名称カナ;
    private RString 今回主治医医療機関_代表者名;
    private RString 今回主治医医療機関_代表者名カナ;
    private RString 今回主治医医療機関_郵便番号;
    private RString 今回主治医医療機関_住所;
    private RString 今回主治医医療機関_電話番号;
    private boolean 今回主治医医療機関_状況フラグ;
    private RString 今回主治医_主治医氏名;
    private RString 今回主治医_主治医カナ;
    private RString 今回主治医_性別;
    private RString 今回主治医_診療科名称;
    private boolean 今回主治医_状況フラグ;
    private RString 今回申請_厚労省IF識別コード;
    private RString 今回一次判定結果_要介護認定一次判定結果コード;
    private FlexibleDate 今回調査依頼_認定調査依頼年月日;
    private FlexibleDate 今回計画情報_認定調査予定年月日;
    private FlexibleDate 今回完了情報_認定調査完了年月日;
    private FlexibleDate 今回意見書作成依頼_主治医意見書作成依頼年月日;
    private FlexibleDate 今回計画情報_主治医意見書登録予定年月日;
    private FlexibleDate 今回意見書情報_主治医意見書受領年月日;
    private FlexibleDate 今回結果情報_介護認定審査会資料作成年月日;
    private FlexibleDate 今回計画情報_認定審査会予定年月日;
    private FlexibleDate 受給者台帳_認定年月日;
    private FlexibleDate 今回一次判定結果_要介護認定一次判定年月日;
    private RString 受給者台帳_要介護認定状態区分コード;
    private FlexibleDate 受給者台帳_認定有効期間開始年月日;
    private FlexibleDate 受給者台帳_認定有効期間終了年月日;
    private boolean 受給者台帳_旧措置者フラグ;
    private RString 受給者台帳_みなし要介護区分コード;
    private RString 今回結果情報_介護認定審査会意見;
    private RString 受給者台帳_指定サービス種類01;
    private RString 受給者台帳_指定サービス種類02;
    private RString 受給者台帳_指定サービス種類03;
    private RString 受給者台帳_指定サービス種類04;
    private RString 受給者台帳_指定サービス種類05;
    private RString 受給者台帳_指定サービス種類06;
    private FlexibleDate 受給者台帳_喪失年月日;
    private RString 受給者台帳_直近異動事由コード;
    private RString 受給者台帳_有効無効区分;
    private RString 受給者台帳_データ区分;
    private RString 受給者台帳_異動理由;
    private RString 受給者台帳_削除事由コード;
    private FlexibleDate 初回受給情報_受給申請年月日;
    private FlexibleDate 初回受給情報_認定年月日;
    private RString 初回申請_厚労省IF識別コード;
    private RString 初回受給情報_要介護認定状態区分コード;
    private FlexibleDate 初回受給情報_認定有効期間開始年月日;
    private FlexibleDate 初回受給情報_認定有効期間終了年月日;
    private RString 初回受給情報_受給申請事由;
    private RString 初回申請_要支援者認定申請区分;
    private RString 初回受給情報_みなし要介護区分コード;
    private FlexibleDate 初回受給情報_当初認定有効開始年月日;
    private FlexibleDate 初回受給情報_当初認定有効終了年月日;
    private FlexibleDate 前回受給情報_受給申請年月日;
    private FlexibleDate 前回受給情報_認定年月日;
    private RString 前回申請_厚労省IF識別コード;
    private RString 前回受給情報_要介護認定状態区分コード;
    private FlexibleDate 前回受給情報_認定有効期間開始年月日;
    private FlexibleDate 前回受給情報_認定有効期間終了年月日;
    private RString 前回受給情報_受給申請事由;
    private RString 前回申請_要支援者認定申請区分;
    private RString 前回受給情報_みなし要介護区分コード;
    private FlexibleDate 前回受給情報_当初認定有効開始年月日;
    private FlexibleDate 前回受給情報_当初認定有効終了年月日;
    private FlexibleDate 前々回受給情報_受給申請年月日;
    private FlexibleDate 前々回受給情報_認定年月日;
    private RString 前々回申請_厚労省IF識別コード;
    private RString 前々回受給情報_要介護認定状態区分コード;
    private FlexibleDate 前々回受給情報_認定有効期間開始年月日;
    private FlexibleDate 前々回受給情報_認定有効期間終了年月日;
    private RString 前々回受給情報_受給申請事由;
    private RString 前々回申請_要支援者認定申請区分;
    private RString 前々回受給情報_みなし要介護区分コード;
    private FlexibleDate 前々回受給情報_当初認定有効開始年月日;
    private FlexibleDate 前々回受給情報_当初認定有効終了年月日;
    private RString 今回調査結果_基本_認定調査_障害高齢者の日常生活自立度コード;
    private RString 今回調査結果_基本_認定調査_認知症高齢者の日常生活自立度コード;
    private RString 受給者台帳_支給限度単位数;
    private FlexibleDate 受給者台帳_支給限度有効開始年月日;
    private FlexibleDate 受給者台帳_支給限度有効終了年月日;
    private RString 受給者台帳_短期入所支給限度日数;
    private FlexibleDate 受給者台帳_短期入所支給限度開始年月日;
    private FlexibleDate 受給者台帳_短期入所支給限度終了年月日;
    private FlexibleDate 受給者台帳_当初認定有効開始年月日;
    private FlexibleDate 受給者台帳_当初認定有効終了年月日;
    private FlexibleDate 今回申請_延期通知発行年月日;
    private RString 今回申請_延期通知発行回数;
    private FlexibleDate 今回申請_延期見込期間開始年月日;
    private FlexibleDate 今回申請_延期見込期間終了年月日;
    private FlexibleDate 受給者台帳_受給資格証明書発行年月日１;
    private FlexibleDate 受給者台帳_受給資格証明書発行年月日２;
    private boolean 受給者台帳_資格取得前申請フラグ;
    private boolean 今回申請_指定医フラグ;
    private RString 後期高齢者情報_後期高齢保険者番号市町村;
    private RString 後期高齢者情報_被保険者番号;
    private FlexibleDate 後期高齢者情報_資格取得日;
    private RString 後期高齢者情報_登録区分;
    private FlexibleDate 後期高齢者情報_資格喪失日;
    private RString 居宅届出_届出区分;
    private RString 事業者作成_作成区分コード;
    private RString 事業者作成_計画事業者番号;
    private RString 計画事業者_事業者名称;
    private RString 計画事業者_事業者名称カナ;
    private RString 計画事業者代表者_代表者名;
    private RString 計画事業者代表者_代表者名カナ;
    private FlexibleDate 事業者作成_適用開始年月日;
    private FlexibleDate 事業者作成_適用終了年月日;
    private FlexibleDate 居宅届出_届出年月日;
    private FlexibleDate 自己作成_計画作成年月日;
    private FlexibleDate 自己作成_計画変更年月日;
    private RString 自己作成_計画変更事由;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private UaFt250FindAtesakiEntity atesakiEntity;
}
