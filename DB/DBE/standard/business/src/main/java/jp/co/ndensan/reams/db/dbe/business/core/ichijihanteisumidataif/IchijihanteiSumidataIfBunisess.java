/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijihanteisumidataif;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ichijihanteisumidataif.IchijihanteiSumidataIftProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataIDataShutsuryokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataIf09AEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataIfEucEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 一次判定データ出力Bunisessです。
 *
 * @reamsid_L DBE-1610-020 wanghui
 */
public class IchijihanteiSumidataIfBunisess {

    private final RString 項目 = new RString("0");
    private final RString 予防給付サービス = new RString("1");
    private final RString 介護給付サービス = new RString("2");

    /**
     * ファイル一次判定済データ09B。
     *
     * @param entity IchijihanteiSumidataIDataShutsuryokuRelateEntity
     * @return 一次判定済データ09B
     */
    public IchijihanteiSumidataIfEucEntity set一次判定済データ09B(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity) {
        IchijihanteiSumidataIfEucEntity eucEntity = new IchijihanteiSumidataIfEucEntity();
        eucEntity.set識別コード(entity.get厚労省IF識別コード());
        eucEntity.set保険者番号(entity.get保険者番号());
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set認定申請日(nullchck(entity.get認定申請年月日()));
        eucEntity.set枝番(項目);
        eucEntity.set申請区分法令コード(entity.get申請区分法令コード());
        eucEntity.set申請区分申請時コード(entity.get申請区分申請時コード());
        eucEntity.set取下区分コード(entity.get取下区分コード());
        eucEntity.set被保険者区分コード(entity.get被保険者区分コード());
        eucEntity.set申請代行区分コード(entity.get申請代行区分コート());
        eucEntity.set生年月日(nullchck(entity.get生年月日()));
        eucEntity.set年齢(entity.get年齢());
        eucEntity.set性別コード(entity.get性別コード());
        eucEntity.set被保険者ｶﾅ氏名(entity.get被保険者氏名カナ());
        eucEntity.set被保険者漢字氏名(entity.get被保険者氏名());
        eucEntity.set郵便番号(entity.get郵便番号());
        eucEntity.set住所(entity.get住所());
        eucEntity.set電話番号(entity.get電話番号());
        eucEntity.set病院施設等の名称(entity.get施設名());
        eucEntity.set病院施設等の所在地(entity.get施設住所());
        eucEntity.set前回の認定審査会結果(entity.get前回要介護状態区分コード());
        eucEntity.set前回の認定有効期間開始(nullchck(entity.get前回認定有効期間開始()));
        eucEntity.set前回の認定有効期間終了(nullchck(entity.get前回認定有効期間終了()));
        eucEntity.set主治医医療機関番号(entity.get主治医医療機関コード());
        eucEntity.set主治医番号(entity.get主治医コード());
        eucEntity.set意見書依頼日(nullchck(entity.get主治医意見書作成依頼年月日()));
        eucEntity.set意見書入手日(nullchck(entity.get主治医意見書受領年月日()));
        eucEntity.set意見書短期記憶(entity.get意見書短期記憶());
        eucEntity.set意見書認知能力(entity.get日常の意思決定を行うための認知能力());
        eucEntity.set意見書伝達能力(entity.get自分の意思の伝達能力());
        eucEntity.set意見書食事行為(entity.get食事行為());
        eucEntity.set意見書認知症高齢者の日常生活自立度(entity.get意見書認知症高齢者自立度());
        eucEntity.set調査依頼日(nullchck(entity.get調査依頼日()));
        eucEntity.set調査実施日(nullchck(entity.get実施年月日()));
        eucEntity.set指定居宅介護支援事業者等番号(entity.get事業者番号());
        eucEntity.set委託区分(entity.get委託区分());
        eucEntity.set認定調査員番号(entity.get認定調査員コード());
        eucEntity.set認定調査員資格コード(entity.get調査員資格());
        eucEntity.set一次判定日(nullchck(entity.get一次判定日()));
        eucEntity.set一次判定結果(entity.get一次判定結果());
        eucEntity.set一次判定結果認知症加算(entity.get一次判定結果認知症加算());
        eucEntity.set要介護認定等基準時間(entity.get要介護認定等基準時間());
        eucEntity.set要介護認定等基準時間食事(entity.get要介護認定等基準時間食事());
        eucEntity.set要介護認定等基準時間排泄(entity.get要介護認定等基準時間排泄());
        eucEntity.set要介護認定等基準時間移動(entity.get要介護認定等基準時間移動());
        eucEntity.set要介護認定等基準時間清潔保持(entity.get要介護認定等基準時間清潔保持());
        eucEntity.set要介護認定等基準時間間接ケア(entity.get要介護認定等基準時間間接ケア());
        eucEntity.set要介護認定等基準時間BPSD関連(entity.get要介護認定等基準時間BPSD関連());
        eucEntity.set要介護認定等基準時間医療関連(entity.get要介護認定等基準時間医療関連());
        eucEntity.set要介護認定等基準時間機能訓練(entity.get要介護認定等基準時間機能訓練());
        eucEntity.set要介護認定等基準時間認知症加算(entity.get要介護認定等基準時間認知症加算());
        eucEntity.set中間評価項目得点第１群(entity.get中間評価項目得点第1群());
        eucEntity.set中間評価項目得点第２群(entity.get中間評価項目得点第2群());
        eucEntity.set中間評価項目得点第３群(entity.get中間評価項目得点第3群());
        eucEntity.set中間評価項目得点第４群(entity.get中間評価項目得点第4群());
        eucEntity.set中間評価項目得点第５群(entity.get中間評価項目得点第5群());
        eucEntity.set一次判定警告配列コード(entity.get警告コード());
        eucEntity.set状態の安定性(entity.get状態の安定性());
        eucEntity.set認知症自立度Ⅱ以上の蓋然性(entity.get認知症自立度Ⅱ以上の蓋然性());
        eucEntity.set認知機能及び状態安定性から推定される給付区分(entity.get給付区分());
        eucEntity.set認定審査会資料作成日(RString.EMPTY);
        eucEntity.set認定審査会予定日(RString.EMPTY);
        eucEntity.set合議体番号(RString.EMPTY);
        eucEntity.set審査会資料番号(RString.EMPTY);
        eucEntity.set二次判定日(RString.EMPTY);
        eucEntity.set二次判定結果(RString.EMPTY);
        eucEntity.set認定有効期間開始(RString.EMPTY);
        eucEntity.set認定有効期間終了(RString.EMPTY);
        eucEntity.set要介護１の場合の状態像(RString.EMPTY);
        eucEntity.set現在のサービス区分コード(entity.getサービス区分コード());
        eucEntity.set現在の状況(entity.get施設利用());
        set介護給付サービス(entity, eucEntity);
        set予防給付サービス(entity, eucEntity);
        set認定調査票調査項目(entity, eucEntity);
        eucEntity.set障害高齢者自立度(entity.get障害高齢者自立度日常生活自立度());
        eucEntity.set認知症高齢者自立度(entity.get認知症高齢者自立度日常生活自立度());
        set前回結果認定調査票調査項目(entity, eucEntity);
        eucEntity.set前回結果障害高齢者自立度(entity.get前回結果障害高齢者自立度日常生活自立度());
        eucEntity.set前回結果認知症高齢者自立度(entity.get前回結果認知症高齢者自立度日常生活自立度());
        eucEntity.set前回結果一次判定結果(entity.get前回結果一次判定結果());
        eucEntity.set前回結果一次判定結果認知症加算(entity.get前回結果一次判定結果認知症加算());
        eucEntity.set前回結果要介護認定等基準時間(entity.get前回結果要介護認定等基準時間());
        eucEntity.set前回結果要介護認定等基準時間食事(entity.get前回結果要介護認定等基準時間食事());
        eucEntity.set前回結果要介護認定等基準時間排泄(entity.get前回結果要介護認定等基準時間排泄());
        eucEntity.set前回結果要介護認定等基準時間移動(entity.get前回結果要介護認定等基準時間移動());
        eucEntity.set前回結果要介護認定等基準時間清潔保持(entity.get前回結果要介護認定等基準時間清潔保持());
        eucEntity.set前回結果要介護認定等基準時間間接ケア(entity.get前回結果要介護認定等基準時間間接ケア());
        eucEntity.set前回結果要介護認定等基準時間BPSD関連(entity.get前回結果要介護認定等基準時間BPSD関連());
        eucEntity.set前回結果要介護認定等基準時間医療関連(entity.get前回結果要介護認定等基準時間医療関連());
        eucEntity.set前回結果要介護認定等基準時間機能訓練(entity.get前回結果要介護認定等基準時間機能訓練());
        eucEntity.set前回結果要介護認定等基準時間認知症加算(entity.get前回結果要介護認定等基準時間認知症加算());
        eucEntity.set前回結果中間評価項目得点第１群(entity.get前回結果中間評価項目得点第1群());
        eucEntity.set前回結果中間評価項目得点第２群(entity.get前回結果中間評価項目得点第2群());
        eucEntity.set前回結果中間評価項目得点第３群(entity.get前回結果中間評価項目得点第3群());
        eucEntity.set前回結果中間評価項目得点第４群(entity.get前回結果中間評価項目得点第4群());
        eucEntity.set前回結果中間評価項目得点第５群(entity.get前回結果中間評価項目得点第5群());
        eucEntity.set前回結果状態の安定性(entity.get前回結果状態の安定性());
        eucEntity.set前回結果認知症自立度Ⅱ以上の蓋然性(entity.get前回結果認知症自立度Ⅱ以上の蓋然性());
        eucEntity.set前回結果認知機能及び状態安定性から推定される給付区分(entity.get給付区分());
        eucEntity.set前回結果一次判定警告コード(entity.get前回結果警告コード());
        eucEntity.set前回結果申請日(nullchck(entity.get前回結果申請日()));
        eucEntity.set前回結果二次判定日(nullchck(entity.get前回結果二次判定日()));
        eucEntity.set前回結果現在のサービス区分コード(entity.get前回結果サービス区分コード());
        eucEntity.set前回結果現在の状況(entity.get前回結果施設利用());
        set前回結果介護給付サービス(entity, eucEntity);
        set前回結果予防給付サービス(entity, eucEntity);
        eucEntity.set前回識別コード(entity.get前回識別コード());
        eucEntity.set認定審査会意見等(RString.EMPTY);
        eucEntity.setコメント等(entity.getコメント等());
        return eucEntity;
    }

    /**
     * ファイル一次判定済データ09B。
     *
     * @param entity IchijihanteiSumidataIDataShutsuryokuRelateEntity
     * @return 一次判定済データ09B
     */
    public IchijihanteiSumidataIf09AEucEntity set一次判定済データ09A(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity) {
        IchijihanteiSumidataIf09AEucEntity eucEntity = new IchijihanteiSumidataIf09AEucEntity();
        eucEntity.set識別コード(entity.get厚労省IF識別コード());
        eucEntity.set保険者番号(entity.get保険者番号());
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set認定申請日(nullchck(entity.get認定申請年月日()));
        eucEntity.set枝番(項目);
        eucEntity.set申請種別コード(entity.get申請区分申請時コード());
        eucEntity.set取下区分コード(entity.get取下区分コード());
        eucEntity.set被保険者区分コード(entity.get被保険者区分コード());
        eucEntity.set申請代行区分コード(entity.get申請代行区分コート());
        eucEntity.set生年月日(nullchck(entity.get生年月日()));
        eucEntity.set年齢(entity.get年齢());
        eucEntity.set性別コード(entity.get性別コード());
        eucEntity.set被保険者ｶﾅ氏名(entity.get被保険者氏名カナ());
        eucEntity.set被保険者漢字氏名(entity.get被保険者氏名());
        eucEntity.set郵便番号(entity.get郵便番号());
        eucEntity.set住所(entity.get住所());
        eucEntity.set電話番号(entity.get電話番号());
        eucEntity.set病院施設等の名称(entity.get施設名());
        eucEntity.set病院施設等の所在地(entity.get施設住所());
        eucEntity.set前回の認定審査会結果(entity.get前回要介護状態区分コード());
        eucEntity.set前回の認定有効期間開始(nullchck(entity.get前回認定有効期間開始()));
        eucEntity.set前回の認定有効期間終了(nullchck(entity.get前回認定有効期間終了()));
        eucEntity.set主治医医療機関番号(entity.get主治医医療機関コード());
        eucEntity.set主治医番号(entity.get主治医コード());
        eucEntity.set意見書依頼日(nullchck(entity.get主治医意見書作成依頼年月日()));
        eucEntity.set意見書入手日(nullchck(entity.get主治医意見書受領年月日()));
        eucEntity.set意見書短期記憶(entity.get意見書短期記憶());
        eucEntity.set意見書認知能力(entity.get日常の意思決定を行うための認知能力());
        eucEntity.set意見書伝達能力(entity.get自分の意思の伝達能力());
        eucEntity.set意見書食事行為(entity.get食事行為());
        eucEntity.set意見書認知症高齢者の日常生活自立度(entity.get意見書認知症高齢者自立度());
        eucEntity.set調査依頼日(nullchck(entity.get調査依頼日()));
        eucEntity.set調査実施日(nullchck(entity.get実施年月日()));
        eucEntity.set指定居宅介護支援事業者等番号(entity.get事業者番号());
        eucEntity.set委託区分(entity.get委託区分());
        eucEntity.set認定調査員番号(entity.get認定調査員コード());
        eucEntity.set認定調査員資格コード(entity.get調査員資格());
        eucEntity.set一次判定日(nullchck(entity.get一次判定日()));
        eucEntity.set一次判定結果(entity.get一次判定結果());
        eucEntity.set一次判定結果認知症加算(entity.get一次判定結果認知症加算());
        eucEntity.set要介護認定等基準時間(entity.get要介護認定等基準時間());
        eucEntity.set要介護認定等基準時間食事(entity.get要介護認定等基準時間食事());
        eucEntity.set要介護認定等基準時間排泄(entity.get要介護認定等基準時間排泄());
        eucEntity.set要介護認定等基準時間移動(entity.get要介護認定等基準時間移動());
        eucEntity.set要介護認定等基準時間清潔保持(entity.get要介護認定等基準時間清潔保持());
        eucEntity.set要介護認定等基準時間間接ケア(entity.get要介護認定等基準時間間接ケア());
        eucEntity.set要介護認定等基準時間BPSD関連(entity.get要介護認定等基準時間BPSD関連());
        eucEntity.set要介護認定等基準時間医療関連(entity.get要介護認定等基準時間医療関連());
        eucEntity.set要介護認定等基準時間機能訓練(entity.get要介護認定等基準時間機能訓練());
        eucEntity.set要介護認定等基準時間認知症加算(entity.get要介護認定等基準時間認知症加算());
        eucEntity.set中間評価項目得点第１群(entity.get中間評価項目得点第1群());
        eucEntity.set中間評価項目得点第２群(entity.get中間評価項目得点第2群());
        eucEntity.set中間評価項目得点第３群(entity.get中間評価項目得点第3群());
        eucEntity.set中間評価項目得点第４群(entity.get中間評価項目得点第4群());
        eucEntity.set中間評価項目得点第５群(entity.get中間評価項目得点第5群());
        eucEntity.set一次判定警告配列コード(entity.get警告コード());
        eucEntity.set状態の安定性(entity.get状態の安定性());
        eucEntity.set認知症自立度Ⅱ以上の蓋然性(entity.get認知症自立度Ⅱ以上の蓋然性());
        eucEntity.set認知機能及び状態安定性から推定される給付区分(entity.get給付区分());
        eucEntity.set認定審査会資料作成日(RString.EMPTY);
        eucEntity.set認定審査会予定日(RString.EMPTY);
        eucEntity.set合議体番号(RString.EMPTY);
        eucEntity.set審査会資料番号(RString.EMPTY);
        eucEntity.set二次判定日(RString.EMPTY);
        eucEntity.set二次判定結果(RString.EMPTY);
        eucEntity.set認定有効期間開始(RString.EMPTY);
        eucEntity.set認定有効期間終了(RString.EMPTY);
        eucEntity.set要介護１の場合の状態像(RString.EMPTY);
        eucEntity.set現在のサービス区分コード(entity.getサービス区分コード());
        eucEntity.set現在の状況(entity.get施設利用());
        set09A介護給付サービス(entity, eucEntity);
        set09A予防給付サービス(entity, eucEntity);
        set認定調査票調査項目(entity, eucEntity);
        eucEntity.set障害高齢者自立度(entity.get障害高齢者自立度日常生活自立度());
        eucEntity.set認知症高齢者自立度(entity.get認知症高齢者自立度日常生活自立度());
        set前回結果認定調査票調査項目(entity, eucEntity);
        eucEntity.set前回結果障害高齢者自立度(entity.get前回結果障害高齢者自立度日常生活自立度());
        eucEntity.set前回結果認知症高齢者自立度(entity.get前回結果認知症高齢者自立度日常生活自立度());
        eucEntity.set前回結果一次判定結果(entity.get前回結果一次判定結果());
        eucEntity.set前回結果一次判定結果認知症加算(entity.get前回結果一次判定結果認知症加算());
        eucEntity.set前回結果要介護認定等基準時間(entity.get前回結果要介護認定等基準時間());
        eucEntity.set前回結果要介護認定等基準時間食事(entity.get前回結果要介護認定等基準時間食事());
        eucEntity.set前回結果要介護認定等基準時間排泄(entity.get前回結果要介護認定等基準時間排泄());
        eucEntity.set前回結果要介護認定等基準時間移動(entity.get前回結果要介護認定等基準時間移動());
        eucEntity.set前回結果要介護認定等基準時間清潔保持(entity.get前回結果要介護認定等基準時間清潔保持());
        eucEntity.set前回結果要介護認定等基準時間間接ケア(entity.get前回結果要介護認定等基準時間間接ケア());
        eucEntity.set前回結果要介護認定等基準時間BPSD関連(entity.get前回結果要介護認定等基準時間BPSD関連());
        eucEntity.set前回結果要介護認定等基準時間医療関連(entity.get前回結果要介護認定等基準時間医療関連());
        eucEntity.set前回結果要介護認定等基準時間機能訓練(entity.get前回結果要介護認定等基準時間機能訓練());
        eucEntity.set前回結果要介護認定等基準時間認知症加算(entity.get前回結果要介護認定等基準時間認知症加算());
        eucEntity.set前回結果中間評価項目得点第１群(entity.get前回結果中間評価項目得点第1群());
        eucEntity.set前回結果中間評価項目得点第２群(entity.get前回結果中間評価項目得点第2群());
        eucEntity.set前回結果中間評価項目得点第３群(entity.get前回結果中間評価項目得点第3群());
        eucEntity.set前回結果中間評価項目得点第４群(entity.get前回結果中間評価項目得点第4群());
        eucEntity.set前回結果中間評価項目得点第５群(entity.get前回結果中間評価項目得点第5群());
        eucEntity.set前回結果状態の安定性(entity.get前回結果状態の安定性());
        eucEntity.set前回結果認知症自立度Ⅱ以上の蓋然性(entity.get前回結果認知症自立度Ⅱ以上の蓋然性());
        eucEntity.set前回結果認知機能及び状態安定性から推定される給付区分(entity.get給付区分());
        eucEntity.set前回結果一次判定警告コード(entity.get前回結果警告コード());
        eucEntity.set前回結果申請日(nullchck(entity.get前回結果申請日()));
        eucEntity.set前回結果二次判定日(nullchck(entity.get前回結果二次判定日()));
        eucEntity.set前回結果現在のサービス区分コード(entity.get前回結果サービス区分コード());
        eucEntity.set前回結果現在の状況(entity.get前回結果施設利用());
        set前回09A介護給付サービス(entity, eucEntity);
        set前回09A予防給付サービス(entity, eucEntity);
        eucEntity.set前回識別コード(entity.get前回識別コード());
        eucEntity.set認定審査会意見等(RString.EMPTY);
        eucEntity.setコメント等(entity.getコメント等());
        return eucEntity;
    }

    private void set介護給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIfEucEntity eucEntity) {
        if (介護給付サービス.equals(entity.getサービス区分コード())) {
            eucEntity.set訪問介護ホームヘルプサービス(entity.get介護訪問介護ホームヘルプ());
            eucEntity.set訪問入浴介護(entity.get介護訪問入浴介護());
            eucEntity.set訪問看護(entity.get介護訪問看護());
            eucEntity.set訪問リハビリテーション(entity.get介護訪問リハビリテーション());
            eucEntity.set居宅療養管理指導(entity.get介護居宅療養管理指導());
            eucEntity.set通所介護デイサービス(entity.get介護通所介護デイサービス());
            eucEntity.set通所リハビリテーション(entity.get介護通所リハビリテーションデイケア());
            eucEntity.set短期入所生活介護ショートステイ(entity.get介護短期入所生活介護ショートステイ());
            eucEntity.set短期入所療養介護(entity.get介護短期入所療養介護());
            eucEntity.set特定施設入居者生活介護(entity.get介護特定施設入居者生活介護());
            eucEntity.set福祉用具貸与(entity.get介護福祉用具貸与());
            eucEntity.set特定福祉用具販売(entity.get介護特定福祉用具販売());
            eucEntity.set住宅改修介護給付(entity.get住宅改修介護給付());
            eucEntity.set夜間対応型訪問介護(entity.get介護夜間対応型訪問介護());
            eucEntity.set認知症対応型通所介護(entity.get介護認知症対応型通所介護());
            eucEntity.set小規模多機能型居宅介護(entity.get介護小規模多機能型居宅介護());
            eucEntity.set認知症対応型共同生活介護グループホーム(entity.get介護認知症対応型共同生活介護グループホーム());
            eucEntity.set地域密着型特定施設入居者生活介護(entity.get介護地域密着型特定施設入居者生活介護());
            eucEntity.set地域密着型介護老人福祉施設入所者生活介護(entity.get老人福祉施設入所者生活介護());
            eucEntity.set定期巡回随時対応型訪問介護看護(entity.get介護定期巡回随時対応型訪問介護看護());
            eucEntity.set複合型サービス(entity.get介護複合型サービス());
        } else {
            eucEntity.set訪問介護ホームヘルプサービス(項目);
            eucEntity.set訪問入浴介護(項目);
            eucEntity.set訪問看護(項目);
            eucEntity.set訪問リハビリテーション(項目);
            eucEntity.set居宅療養管理指導(項目);
            eucEntity.set通所介護デイサービス(項目);
            eucEntity.set通所リハビリテーション(項目);
            eucEntity.set短期入所生活介護ショートステイ(項目);
            eucEntity.set短期入所療養介護(項目);
            eucEntity.set特定施設入居者生活介護(項目);
            eucEntity.set福祉用具貸与(項目);
            eucEntity.set特定福祉用具販売(項目);
            eucEntity.set住宅改修介護給付(項目);
            eucEntity.set夜間対応型訪問介護(項目);
            eucEntity.set認知症対応型通所介護(項目);
            eucEntity.set小規模多機能型居宅介護(項目);
            eucEntity.set認知症対応型共同生活介護グループホーム(項目);
            eucEntity.set地域密着型特定施設入居者生活介護(項目);
            eucEntity.set地域密着型介護老人福祉施設入所者生活介護(項目);
            eucEntity.set定期巡回随時対応型訪問介護看護(項目);
            eucEntity.set複合型サービス(項目);
        }
    }

    private void set予防給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIfEucEntity eucEntity) {
        if (予防給付サービス.equals(entity.getサービス区分コード())) {
            eucEntity.set介護予防訪問介護ホームヘルプサービス(entity.get予防訪問介護ホームヘルプ());
            eucEntity.set介護予防訪問入浴介護(entity.get予防訪問入浴介護());
            eucEntity.set介護予防訪問看護(entity.get予防訪問看護());
            eucEntity.set介護予防訪問リハビリテーション(entity.get予防訪問リハビリテーション());
            eucEntity.set介護予防居宅療養管理指導(entity.get予防居宅療養管理指導());
            eucEntity.set介護予防通所介護デイサービス(entity.get予防通所介護デイサービス());
            eucEntity.set介護予防通所リハビリテーション(entity.get予防通所リハビリテーションデイケア());
            eucEntity.set介護予防短期入所生活介護ショートステイ(entity.get予防短期入所生活介護ショートステイ());
            eucEntity.set介護予防短期入所療養介護(entity.get予防短期入所療養介護());
            eucEntity.set介護予防特定施設入居者生活介護(entity.get予防特定施設入居者生活介護());
            eucEntity.set介護予防福祉用具貸与(entity.get予防福祉用具貸与());
            eucEntity.set特定介護予防福祉用具販売(entity.get予防特定福祉用具販売());
            eucEntity.set住宅改修予防給付(entity.get住宅改修予防給付());
            eucEntity.set介護予防認知症対応型通所介護(entity.get予防認知症対応型通所介護());
            eucEntity.set介護予防小規模多機能型居宅介護(entity.get予防小規模多機能型居宅介護());
            eucEntity.set介護予防認知症対応型共同生活介護グループホーム(entity.get予防認知症対応型共同生活介護グループホーム());
        } else {
            eucEntity.set介護予防訪問介護ホームヘルプサービス(項目);
            eucEntity.set介護予防訪問入浴介護(項目);
            eucEntity.set介護予防訪問看護(項目);
            eucEntity.set介護予防訪問リハビリテーション(項目);
            eucEntity.set介護予防居宅療養管理指導(項目);
            eucEntity.set介護予防通所介護デイサービス(項目);
            eucEntity.set介護予防通所リハビリテーション(項目);
            eucEntity.set介護予防短期入所生活介護ショートステイ(項目);
            eucEntity.set介護予防短期入所療養介護(項目);
            eucEntity.set介護予防特定施設入居者生活介護(項目);
            eucEntity.set介護予防福祉用具貸与(項目);
            eucEntity.set特定介護予防福祉用具販売(項目);
            eucEntity.set住宅改修予防給付(項目);
            eucEntity.set介護予防認知症対応型通所介護(項目);
            eucEntity.set介護予防小規模多機能型居宅介護(項目);
            eucEntity.set介護予防認知症対応型共同生活介護グループホーム(項目);
        }
    }

    private void set認定調査票調査項目(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIfEucEntity eucEntity) {
        eucEntity.set麻痺左上肢(entity.get麻痺左上肢());
        eucEntity.set麻痺左下肢(entity.get麻痺左下肢());
        eucEntity.set麻痺右上肢(entity.get麻痺右上肢());
        eucEntity.set麻痺右下肢(entity.get麻痺右下肢());
        eucEntity.set麻痺その他(entity.get麻痺その他());
        eucEntity.set拘縮肩関節(entity.get拘縮肩関節());
        eucEntity.set拘縮股関節(entity.get拘縮股関節());
        eucEntity.set拘縮膝関節(entity.get拘縮膝関節());
        eucEntity.set拘縮その他(entity.get拘縮その他());
        eucEntity.set寝返り(entity.get寝返り());
        eucEntity.set起き上がり(entity.get起き上がり());
        eucEntity.set座位保持(entity.get座位保持());
        eucEntity.set両足での立位(entity.get両足での立位());
        eucEntity.set歩行(entity.get歩行());
        eucEntity.set立ち上がり(entity.get立ち上がり());
        eucEntity.set片足での立位(entity.get片足での立位());
        eucEntity.set洗身(entity.get洗身());
        eucEntity.setつめ切り(entity.getつめ切り());
        eucEntity.set視力(entity.get視力());
        eucEntity.set聴力(entity.get聴力());
        eucEntity.set移乗(entity.get移乗());
        eucEntity.set移動(entity.get移動());
        eucEntity.setえん下(entity.getえん下());
        eucEntity.set食事摂取(entity.get食事摂取());
        eucEntity.set排尿(entity.get排尿());
        eucEntity.set排便(entity.get排便());
        eucEntity.set口腔清潔(entity.get口腔清潔());
        eucEntity.set洗顔(entity.get洗顔());
        eucEntity.set整髪(entity.get整髪());
        eucEntity.set上衣の着脱(entity.get上衣の着脱());
        eucEntity.setズボン等の着脱(entity.getズボン等の着脱());
        eucEntity.set外出頻度(entity.get外出頻度());
        eucEntity.set意思の伝達(entity.get意思の伝達());
        eucEntity.set毎日の日課を理解(entity.get毎日の日課を理解());
        eucEntity.set生年月日をいう(entity.get生年月日をいう());
        eucEntity.set短期記憶(entity.get短期記憶());
        eucEntity.set自分の名前をいう(entity.get自分の名前をいう());
        eucEntity.set今の季節を理解(entity.get今の季節を理解());
        eucEntity.set場所の理解(entity.get場所の理解());
        eucEntity.set徘徊(entity.get徘徊());
        eucEntity.set外出して戻れない(entity.get外出して戻れない());
        eucEntity.set被害的(entity.get被害的());
        eucEntity.set作話(entity.get作話());
        eucEntity.set感情が不安定(entity.get感情が不安定());
        eucEntity.set昼夜逆転(entity.get昼夜逆転());
        eucEntity.set同じ話をする(entity.get同じ話をする());
        eucEntity.set大声を出す(entity.get大声を出す());
        eucEntity.set介護に抵抗(entity.get介護に抵抗());
        eucEntity.set落ち着きなし(entity.get落ち着きなし());
        eucEntity.set一人で出たがる(entity.get一人で出たがる());
        eucEntity.set収集癖(entity.get収集癖());
        eucEntity.set物や衣類を壊す(entity.get物や衣類を壊す());
        eucEntity.setひどい物忘れ(entity.getひどい物忘れ());
        eucEntity.set独り言独り笑い(entity.get独り言独り笑い());
        eucEntity.set自分勝手に行動する(entity.get自分勝手に行動する());
        eucEntity.set話がまとまらない(entity.get話がまとまらない());
        eucEntity.set薬の内服(entity.get薬の内服());
        eucEntity.set金銭の管理(entity.get金銭の管理());
        eucEntity.set日常の意思決定(entity.get日常の意思決定());
        eucEntity.set集団への不適応(entity.get集団への不適応());
        eucEntity.set買い物(entity.get買い物());
        eucEntity.set簡単な調理(entity.get簡単な調理());
        eucEntity.set点滴の管理(entity.get点滴の管理());
        eucEntity.set中心静脈栄養(entity.get中心静脈栄養());
        eucEntity.set透析(entity.get透析());
        eucEntity.setストーマの処置(entity.getストーマの処置());
        eucEntity.set酸素療法(entity.get酸素療法());
        eucEntity.setレスピレーター(entity.getレスピレーター());
        eucEntity.set気管切開の処置(entity.get気管切開の処置());
        eucEntity.set疼痛の看護(entity.get疼痛の看護());
        eucEntity.set経管栄養(entity.get経管栄養());
        eucEntity.setモニター測定(entity.getモニター測定());
        eucEntity.setじょくそうの処置(entity.getじょくそうの処置());
        eucEntity.setカテーテル(entity.getカテーテル());
    }

    private void set前回結果認定調査票調査項目(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIfEucEntity eucEntity) {
        eucEntity.set前回結果麻痺左上肢(entity.get前回結果麻痺左上肢());
        eucEntity.set前回結果麻痺左下肢(entity.get前回結果麻痺左下肢());
        eucEntity.set前回結果麻痺右上肢(entity.get前回結果麻痺右上肢());
        eucEntity.set前回結果麻痺右下肢(entity.get前回結果麻痺右下肢());
        eucEntity.set前回結果麻痺その他(entity.get前回結果麻痺その他());
        eucEntity.set前回結果拘縮肩関節(entity.get前回結果拘縮肩関節());
        eucEntity.set前回結果拘縮股関節(entity.get前回結果拘縮股関節());
        eucEntity.set前回結果拘縮膝関節(entity.get前回結果拘縮膝関節());
        eucEntity.set前回結果拘縮その他(entity.get前回結果拘縮その他());
        eucEntity.set前回結果寝返り(entity.get前回結果寝返り());
        eucEntity.set前回結果起き上がり(entity.get前回結果起き上がり());
        eucEntity.set前回結果座位保持(entity.get前回結果座位保持());
        eucEntity.set前回結果両足での立位(entity.get前回結果両足での立位());
        eucEntity.set前回結果歩行(entity.get前回結果歩行());
        eucEntity.set前回結果立ち上がり(entity.get前回結果立ち上がり());
        eucEntity.set前回結果片足での立位(entity.get前回結果片足での立位());
        eucEntity.set前回結果洗身(entity.get前回結果洗身());
        eucEntity.set前回結果つめ切り(entity.get前回結果つめ切り());
        eucEntity.set前回結果視力(entity.get前回結果視力());
        eucEntity.set前回結果聴力(entity.get前回結果聴力());
        eucEntity.set前回結果移乗(entity.get前回結果移乗());
        eucEntity.set前回結果移動(entity.get前回結果移動());
        eucEntity.set前回結果えん下(entity.get前回結果えん下());
        eucEntity.set前回結果食事摂取(entity.get前回結果食事摂取());
        eucEntity.set前回結果排尿(entity.get前回結果排尿());
        eucEntity.set前回結果排便(entity.get前回結果排便());
        eucEntity.set前回結果口腔清潔(entity.get前回結果口腔清潔());
        eucEntity.set前回結果洗顔(entity.get前回結果洗顔());
        eucEntity.set前回結果整髪(entity.get前回結果整髪());
        eucEntity.set前回結果上衣の着脱(entity.get前回結果上衣の着脱());
        eucEntity.set前回結果ズボン等の着脱(entity.get前回結果ズボン等の着脱());
        eucEntity.set前回結果外出頻度(entity.get前回結果外出頻度());
        eucEntity.set前回結果意思の伝達(entity.get前回結果意思の伝達());
        eucEntity.set前回結果毎日の日課を理解(entity.get前回結果毎日の日課を理解());
        eucEntity.set前回結果生年月日をいう(entity.get前回結果生年月日をいう());
        eucEntity.set前回結果短期記憶(entity.get前回結果短期記憶());
        eucEntity.set前回結果自分の名前をいう(entity.get前回結果自分の名前をいう());
        eucEntity.set前回結果今の季節を理解(entity.get前回結果今の季節を理解());
        eucEntity.set前回結果場所の理解(entity.get前回結果場所の理解());
        eucEntity.set前回結果徘徊(entity.get前回結果徘徊());
        eucEntity.set前回結果外出して戻れない(entity.get前回結果外出して戻れない());
        eucEntity.set前回結果被害的(entity.get前回結果被害的());
        eucEntity.set前回結果作話(entity.get前回結果作話());
        eucEntity.set前回結果感情が不安定(entity.get前回結果感情が不安定());
        eucEntity.set前回結果昼夜逆転(entity.get前回結果昼夜逆転());
        eucEntity.set前回結果同じ話をする(entity.get前回結果同じ話をする());
        eucEntity.set前回結果大声を出す(entity.get前回結果大声を出す());
        eucEntity.set前回結果介護に抵抗(entity.get前回結果介護に抵抗());
        eucEntity.set前回結果落ち着きなし(entity.get前回結果落ち着きなし());
        eucEntity.set前回結果一人で出たがる(entity.get前回結果一人で出たがる());
        eucEntity.set前回結果収集癖(entity.get前回結果収集癖());
        eucEntity.set前回結果物や衣類を壊す(entity.get前回結果物や衣類を壊す());
        eucEntity.set前回結果ひどい物忘れ(entity.get前回結果ひどい物忘れ());
        eucEntity.set前回結果独り言独り笑い(entity.get前回結果独り言独り笑い());
        eucEntity.set前回結果自分勝手に行動する(entity.get前回結果自分勝手に行動する());
        eucEntity.set前回結果話がまとまらない(entity.get前回結果話がまとまらない());
        eucEntity.set前回結果薬の内服(entity.get前回結果薬の内服());
        eucEntity.set前回結果金銭の管理(entity.get前回結果金銭の管理());
        eucEntity.set前回結果日常の意思決定(entity.get前回結果日常の意思決定());
        eucEntity.set前回結果集団への不適応(entity.get前回結果集団への不適応());
        eucEntity.set前回結果買い物(entity.get前回結果買い物());
        eucEntity.set前回結果簡単な調理(entity.get前回結果簡単な調理());
        eucEntity.set前回結果点滴の管理(entity.get前回結果点滴の管理());
        eucEntity.set前回結果中心静脈栄養(entity.get前回結果中心静脈栄養());
        eucEntity.set前回結果透析(entity.get前回結果透析());
        eucEntity.set前回結果ストーマの処置(entity.get前回結果ストーマの処置());
        eucEntity.set前回結果酸素療法(entity.get前回結果酸素療法());
        eucEntity.set前回結果レスピレーター(entity.get前回結果レスピレーター());
        eucEntity.set前回結果気管切開の処置(entity.get前回結果気管切開の処置());
        eucEntity.set前回結果疼痛の看護(entity.get前回結果疼痛の看護());
        eucEntity.set前回結果経管栄養(entity.get前回結果経管栄養());
        eucEntity.set前回結果モニター測定(entity.get前回結果モニター測定());
        eucEntity.set前回結果じょくそうの処置(entity.get前回結果じょくそうの処置());
        eucEntity.set前回結果カテーテル(entity.get前回結果カテーテル());
    }

    private void set前回結果介護給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIfEucEntity eucEntity) {
        if (介護給付サービス.equals(entity.get前回結果サービス区分コード())) {
            eucEntity.set前回結果訪問介護ホームヘルプサービス(entity.get前回介護訪問介護ホームヘルプ());
            eucEntity.set前回結果訪問入浴介護(entity.get前回介護訪問入浴介護());
            eucEntity.set前回結果訪問看護(entity.get前回介護訪問看護());
            eucEntity.set前回結果訪問リハビリテーション(entity.get前回介護訪問リハビリテーション());
            eucEntity.set前回結果居宅療養管理指導(entity.get前回介護居宅療養管理指導());
            eucEntity.set前回結果通所介護デイサービス(entity.get前回介護通所介護デイサービス());
            eucEntity.set前回結果通所リハビリテーション(entity.get前回介護通所リハビリ());
            eucEntity.set前回結果短期入所生活介護ショートステイ(entity.get前回介護短期入所生活介護());
            eucEntity.set前回結果短期入所療養介護(entity.get前回介護短期入所療養介護());
            eucEntity.set前回結果特定施設入居者生活介護(entity.get前回介護特定施設入居者生活介護());
            eucEntity.set前回結果福祉用具貸与(entity.get前回介護福祉用具貸与());
            eucEntity.set前回結果特定福祉用具販売(entity.get前回介護特定福祉用具販売());
            eucEntity.set前回結果住宅改修介護給付(entity.get前回住宅改修介護給付());
            eucEntity.set前回結果夜間対応型訪問介護(entity.get前回介護夜間対応型訪問介護());
            eucEntity.set前回結果認知症対応型通所介護(entity.get前回介護認知症対応型通所介護());
            eucEntity.set前回結果小規模多機能型居宅介護(entity.get前回介護小規模多機能型居宅介護());
            eucEntity.set前回結果認知症対応型共同生活介護グループホーム(entity.get前回介護グループホーム());
            eucEntity.set前回結果地域密着型特定施設入居者生活介護(entity.get前回介護施設入居者生活介護());
            eucEntity.set前回結果地域密着型介護老人福祉施設入所者生活介護(entity.get前回老人福祉施設入所者生活介護());
            eucEntity.set前回結果定期巡回随時対応型訪問介護看護(entity.get前回介護訪問介護看護());
            eucEntity.set前回結果複合型サービス(entity.get前回介護複合型サービス());
        } else {
            eucEntity.set前回結果訪問介護ホームヘルプサービス(項目);
            eucEntity.set前回結果訪問入浴介護(項目);
            eucEntity.set前回結果訪問看護(項目);
            eucEntity.set前回結果訪問リハビリテーション(項目);
            eucEntity.set前回結果居宅療養管理指導(項目);
            eucEntity.set前回結果通所介護デイサービス(項目);
            eucEntity.set前回結果通所リハビリテーション(項目);
            eucEntity.set前回結果短期入所生活介護ショートステイ(項目);
            eucEntity.set前回結果短期入所療養介護(項目);
            eucEntity.set前回結果特定施設入居者生活介護(項目);
            eucEntity.set前回結果福祉用具貸与(項目);
            eucEntity.set前回結果特定福祉用具販売(項目);
            eucEntity.set前回結果住宅改修介護給付(項目);
            eucEntity.set前回結果夜間対応型訪問介護(項目);
            eucEntity.set前回結果認知症対応型通所介護(項目);
            eucEntity.set前回結果小規模多機能型居宅介護(項目);
            eucEntity.set前回結果認知症対応型共同生活介護グループホーム(項目);
            eucEntity.set前回結果地域密着型特定施設入居者生活介護(項目);
            eucEntity.set前回結果地域密着型介護老人福祉施設入所者生活介護(項目);
            eucEntity.set前回結果定期巡回随時対応型訪問介護看護(項目);
            eucEntity.set前回結果複合型サービス(項目);
        }
    }

    private void set前回結果予防給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIfEucEntity eucEntity) {
        if (予防給付サービス.equals(entity.get前回結果サービス区分コード())) {
            eucEntity.set前回結果介護予防訪問介護ホームヘルプサービス(entity.get前回予防訪問介護ホームヘルプ());
            eucEntity.set前回結果介護予防訪問入浴介護(entity.get前回予防訪問入浴介護());
            eucEntity.set前回結果介護予防訪問看護(entity.get前回予防訪問看護());
            eucEntity.set前回結果介護予防訪問リハビリテーション(entity.get前回予防訪問リハビリテーション());
            eucEntity.set前回結果介護予防居宅療養管理指導(entity.get前回予防居宅療養管理指導());
            eucEntity.set前回結果介護予防通所介護デイサービス(entity.get前回予防通所介護デイサービス());
            eucEntity.set前回結果介護予防通所リハビリテーション(entity.get前回予防通所リハビリ());
            eucEntity.set前回結果介護予防短期入所生活介護ショートステイ(entity.get前回予防短期入所生活介護());
            eucEntity.set前回結果介護予防短期入所療養介護(entity.get前回予防短期入所療養介護());
            eucEntity.set前回結果介護予防特定施設入居者生活介護(entity.get前回予防特定施設入居者生活介護());
            eucEntity.set前回結果介護予防福祉用具貸与(entity.get前回予防福祉用具貸与());
            eucEntity.set前回結果特定介護予防福祉用具販売(entity.get前回予防特定福祉用具販売());
            eucEntity.set前回結果住宅改修予防給付(entity.get前回住宅改修予防給付());
            eucEntity.set前回結果介護予防認知症対応型通所介護(entity.get前回予防認知症対応型通所介護());
            eucEntity.set前回結果介護予防小規模多機能型居宅介護(entity.get前回予防小規模多機能型居宅介護());
            eucEntity.set前回結果介護予防認知症対応型共同生活介護グループホーム(entity.get前回予防グループホーム());
        } else {
            eucEntity.set前回結果介護予防訪問介護ホームヘルプサービス(項目);
            eucEntity.set前回結果介護予防訪問入浴介護(項目);
            eucEntity.set前回結果介護予防訪問看護(項目);
            eucEntity.set前回結果介護予防訪問リハビリテーション(項目);
            eucEntity.set前回結果介護予防居宅療養管理指導(項目);
            eucEntity.set前回結果介護予防通所介護デイサービス(項目);
            eucEntity.set前回結果介護予防通所リハビリテーション(項目);
            eucEntity.set前回結果介護予防短期入所生活介護ショートステイ(項目);
            eucEntity.set前回結果介護予防短期入所療養介護(項目);
            eucEntity.set前回結果介護予防特定施設入居者生活介護(項目);
            eucEntity.set前回結果介護予防福祉用具貸与(項目);
            eucEntity.set前回結果特定介護予防福祉用具販売(項目);
            eucEntity.set前回結果住宅改修予防給付(項目);
            eucEntity.set前回結果介護予防認知症対応型通所介護(項目);
            eucEntity.set前回結果介護予防小規模多機能型居宅介護(項目);
            eucEntity.set前回結果介護予防認知症対応型共同生活介護グループホーム(項目);
        }
    }

    private void set09A介護給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIf09AEucEntity eucEntity) {
        if (介護給付サービス.equals(entity.getサービス区分コード())) {
            eucEntity.set訪問介護ホームヘルプサービス(entity.get介護訪問介護ホームヘルプ());
            eucEntity.set訪問入浴介護(entity.get介護訪問入浴介護());
            eucEntity.set訪問看護(entity.get介護訪問看護());
            eucEntity.set訪問リハビリテーション(entity.get介護訪問リハビリテーション());
            eucEntity.set居宅療養管理指導(entity.get介護居宅療養管理指導());
            eucEntity.set通所介護デイサービス(entity.get介護通所介護デイサービス());
            eucEntity.set通所リハビリテーション(entity.get介護通所リハビリテーションデイケア());
            eucEntity.set短期入所生活介護ショートステイ(entity.get介護短期入所生活介護ショートステイ());
            eucEntity.set短期入所療養介護(entity.get介護短期入所療養介護());
            eucEntity.set特定施設入居者生活介護(entity.get介護特定施設入居者生活介護());
            eucEntity.set福祉用具貸与(entity.get介護福祉用具貸与());
            eucEntity.set特定福祉用具販売(entity.get介護特定福祉用具販売());
            eucEntity.set住宅改修介護給付(entity.get住宅改修介護給付());
            eucEntity.set夜間対応型訪問介護(entity.get介護夜間対応型訪問介護());
            eucEntity.set認知症対応型通所介護(entity.get介護認知症対応型通所介護());
            eucEntity.set小規模多機能型居宅介護(entity.get介護小規模多機能型居宅介護());
            eucEntity.set認知症対応型共同生活介護グループホーム(entity.get介護認知症対応型共同生活介護グループホーム());
            eucEntity.set地域密着型特定施設入居者生活介護(entity.get介護地域密着型特定施設入居者生活介護());
            eucEntity.set地域密着型介護老人福祉施設入所者生活介護(entity.get老人福祉施設入所者生活介護());
        } else {
            eucEntity.set訪問介護ホームヘルプサービス(項目);
            eucEntity.set訪問入浴介護(項目);
            eucEntity.set訪問看護(項目);
            eucEntity.set訪問リハビリテーション(項目);
            eucEntity.set居宅療養管理指導(項目);
            eucEntity.set通所介護デイサービス(項目);
            eucEntity.set通所リハビリテーション(項目);
            eucEntity.set短期入所生活介護ショートステイ(項目);
            eucEntity.set短期入所療養介護(項目);
            eucEntity.set特定施設入居者生活介護(項目);
            eucEntity.set福祉用具貸与(項目);
            eucEntity.set特定福祉用具販売(項目);
            eucEntity.set住宅改修介護給付(項目);
            eucEntity.set夜間対応型訪問介護(項目);
            eucEntity.set認知症対応型通所介護(項目);
            eucEntity.set小規模多機能型居宅介護(項目);
            eucEntity.set認知症対応型共同生活介護グループホーム(項目);
            eucEntity.set地域密着型特定施設入居者生活介護(項目);
            eucEntity.set地域密着型介護老人福祉施設入所者生活介護(項目);
        }
    }

    private void set09A予防給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIf09AEucEntity eucEntity) {
        if (予防給付サービス.equals(entity.getサービス区分コード())) {
            eucEntity.set介護予防訪問介護ホームヘルプサービス(entity.get予防訪問介護ホームヘルプ());
            eucEntity.set介護予防訪問入浴介護(entity.get予防訪問入浴介護());
            eucEntity.set介護予防訪問看護(entity.get予防訪問看護());
            eucEntity.set介護予防訪問リハビリテーション(entity.get予防訪問リハビリテーション());
            eucEntity.set介護予防居宅療養管理指導(entity.get予防居宅療養管理指導());
            eucEntity.set介護予防通所介護デイサービス(entity.get予防通所介護デイサービス());
            eucEntity.set介護予防通所リハビリテーション(entity.get予防通所リハビリテーションデイケア());
            eucEntity.set介護予防短期入所生活介護ショートステイ(entity.get予防短期入所生活介護ショートステイ());
            eucEntity.set介護予防短期入所療養介護(entity.get予防短期入所療養介護());
            eucEntity.set介護予防特定施設入居者生活介護(entity.get予防特定施設入居者生活介護());
            eucEntity.set介護予防福祉用具貸与(entity.get予防福祉用具貸与());
            eucEntity.set特定介護予防福祉用具販売(entity.get予防特定福祉用具販売());
            eucEntity.set住宅改修予防給付(entity.get住宅改修予防給付());
            eucEntity.set介護予防認知症対応型通所介護(entity.get予防認知症対応型通所介護());
            eucEntity.set介護予防小規模多機能型居宅介護(entity.get予防小規模多機能型居宅介護());
            eucEntity.set介護予防認知症対応型共同生活介護グループホーム(entity.get予防認知症対応型共同生活介護グループホーム());
        } else {
            eucEntity.set介護予防訪問介護ホームヘルプサービス(項目);
            eucEntity.set介護予防訪問入浴介護(項目);
            eucEntity.set介護予防訪問看護(項目);
            eucEntity.set介護予防居宅療養管理指導(項目);
            eucEntity.set介護予防通所介護デイサービス(項目);
            eucEntity.set介護予防通所リハビリテーション(項目);
            eucEntity.set介護予防短期入所生活介護ショートステイ(項目);
            eucEntity.set介護予防短期入所療養介護(項目);
            eucEntity.set介護予防特定施設入居者生活介護(項目);
            eucEntity.set介護予防福祉用具貸与(項目);
            eucEntity.set特定介護予防福祉用具販売(項目);
            eucEntity.set住宅改修予防給付(項目);
            eucEntity.set介護予防認知症対応型通所介護(項目);
            eucEntity.set介護予防小規模多機能型居宅介護(項目);
            eucEntity.set介護予防認知症対応型共同生活介護グループホーム(項目);
        }
    }

    private void set前回09A介護給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIf09AEucEntity eucEntity) {
        if (介護給付サービス.equals(entity.getサービス区分コード())) {
            eucEntity.set前回結果訪問介護ホームヘルプサービス(entity.get前回介護訪問介護ホームヘルプ());
            eucEntity.set前回結果訪問入浴介護(entity.get前回介護訪問入浴介護());
            eucEntity.set前回結果訪問看護(entity.get前回介護訪問看護());
            eucEntity.set前回結果訪問リハビリテーション(entity.get前回介護訪問リハビリテーション());
            eucEntity.set前回結果居宅療養管理指導(entity.get前回介護居宅療養管理指導());
            eucEntity.set前回結果通所介護デイサービス(entity.get前回介護通所介護デイサービス());
            eucEntity.set前回結果通所リハビリテーション(entity.get前回介護通所リハビリ());
            eucEntity.set前回結果短期入所生活介護ショートステイ(entity.get前回介護短期入所生活介護());
            eucEntity.set前回結果短期入所療養介護(entity.get前回介護短期入所療養介護());
            eucEntity.set前回結果特定施設入居者生活介護(entity.get前回介護特定施設入居者生活介護());
            eucEntity.set前回結果福祉用具貸与(entity.get前回介護福祉用具貸与());
            eucEntity.set前回結果特定福祉用具販売(entity.get前回介護特定福祉用具販売());
            eucEntity.set前回結果住宅改修介護給付(entity.get前回住宅改修介護給付());
            eucEntity.set前回結果夜間対応型訪問介護(entity.get前回介護夜間対応型訪問介護());
            eucEntity.set前回結果認知症対応型通所介護(entity.get前回介護認知症対応型通所介護());
            eucEntity.set前回結果小規模多機能型居宅介護(entity.get前回介護小規模多機能型居宅介護());
            eucEntity.set前回結果認知症対応型共同生活介護グループホーム(entity.get前回介護グループホーム());
            eucEntity.set前回結果地域密着型特定施設入居者生活介護(entity.get前回介護施設入居者生活介護());
            eucEntity.set前回結果地域密着型介護老人福祉施設入所者生活介護(entity.get前回老人福祉施設入所者生活介護());
        } else {
            eucEntity.set訪問介護ホームヘルプサービス(項目);
            eucEntity.set訪問入浴介護(項目);
            eucEntity.set訪問看護(項目);
            eucEntity.set訪問リハビリテーション(項目);
            eucEntity.set居宅療養管理指導(項目);
            eucEntity.set通所介護デイサービス(項目);
            eucEntity.set通所リハビリテーション(項目);
            eucEntity.set短期入所生活介護ショートステイ(項目);
            eucEntity.set短期入所療養介護(項目);
            eucEntity.set特定施設入居者生活介護(項目);
            eucEntity.set福祉用具貸与(項目);
            eucEntity.set特定福祉用具販売(項目);
            eucEntity.set住宅改修介護給付(項目);
            eucEntity.set夜間対応型訪問介護(項目);
            eucEntity.set認知症対応型通所介護(項目);
            eucEntity.set小規模多機能型居宅介護(項目);
            eucEntity.set認知症対応型共同生活介護グループホーム(項目);
            eucEntity.set地域密着型特定施設入居者生活介護(項目);
            eucEntity.set地域密着型介護老人福祉施設入所者生活介護(項目);
        }
    }

    private void set前回09A予防給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIf09AEucEntity eucEntity) {
        if (予防給付サービス.equals(entity.getサービス区分コード())) {
            eucEntity.set前回結果介護予防訪問介護ホームヘルプサービス(entity.get前回予防訪問介護ホームヘルプ());
            eucEntity.set前回結果介護予防訪問入浴介護(entity.get前回予防訪問入浴介護());
            eucEntity.set前回結果介護予防訪問看護(entity.get前回予防訪問看護());
            eucEntity.set前回結果介護予防訪問リハビリテーション(entity.get前回予防訪問リハビリテーション());
            eucEntity.set前回結果介護予防居宅療養管理指導(entity.get前回予防居宅療養管理指導());
            eucEntity.set前回結果介護予防通所介護デイサービス(entity.get前回予防通所介護デイサービス());
            eucEntity.set前回結果介護予防通所リハビリテーション(entity.get前回予防通所リハビリ());
            eucEntity.set前回結果介護予防短期入所生活介護ショートステイ(entity.get前回予防短期入所生活介護());
            eucEntity.set前回結果介護予防短期入所療養介護(entity.get前回予防短期入所療養介護());
            eucEntity.set前回結果介護予防特定施設入居者生活介護(entity.get前回予防特定施設入居者生活介護());
            eucEntity.set前回結果介護予防福祉用具貸与(entity.get前回予防福祉用具貸与());
            eucEntity.set前回結果特定介護予防福祉用具販売(entity.get前回予防特定福祉用具販売());
            eucEntity.set前回結果住宅改修予防給付(entity.get前回住宅改修予防給付());
            eucEntity.set前回結果介護予防認知症対応型通所介護(entity.get前回予防認知症対応型通所介護());
            eucEntity.set前回結果介護予防小規模多機能型居宅介護(entity.get前回予防小規模多機能型居宅介護());
            eucEntity.set前回結果介護予防認知症対応型共同生活介護グループホーム(entity.get前回予防グループホーム());
        } else {
            eucEntity.set前回結果介護予防訪問介護ホームヘルプサービス(項目);
            eucEntity.set前回結果介護予防訪問入浴介護(項目);
            eucEntity.set前回結果介護予防訪問看護(項目);
            eucEntity.set前回結果介護予防居宅療養管理指導(項目);
            eucEntity.set前回結果介護予防通所介護デイサービス(項目);
            eucEntity.set前回結果介護予防通所リハビリテーション(項目);
            eucEntity.set前回結果介護予防短期入所生活介護ショートステイ(項目);
            eucEntity.set前回結果介護予防短期入所療養介護(項目);
            eucEntity.set前回結果介護予防特定施設入居者生活介護(項目);
            eucEntity.set前回結果介護予防福祉用具貸与(項目);
            eucEntity.set前回結果特定介護予防福祉用具販売(項目);
            eucEntity.set前回結果住宅改修予防給付(項目);
            eucEntity.set前回結果介護予防認知症対応型通所介護(項目);
            eucEntity.set前回結果介護予防小規模多機能型居宅介護(項目);
            eucEntity.set前回結果介護予防認知症対応型共同生活介護グループホーム(項目);
        }
    }

    private void set認定調査票調査項目(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIf09AEucEntity eucEntity) {
        eucEntity.set麻痺左上肢(entity.get麻痺左上肢());
        eucEntity.set麻痺左下肢(entity.get麻痺左下肢());
        eucEntity.set麻痺右上肢(entity.get麻痺右上肢());
        eucEntity.set麻痺右下肢(entity.get麻痺右下肢());
        eucEntity.set麻痺その他(entity.get麻痺その他());
        eucEntity.set拘縮肩関節(entity.get拘縮肩関節());
        eucEntity.set拘縮股関節(entity.get拘縮股関節());
        eucEntity.set拘縮膝関節(entity.get拘縮膝関節());
        eucEntity.set拘縮その他(entity.get拘縮その他());
        eucEntity.set寝返り(entity.get寝返り());
        eucEntity.set起き上がり(entity.get起き上がり());
        eucEntity.set座位保持(entity.get座位保持());
        eucEntity.set両足での立位(entity.get両足での立位());
        eucEntity.set歩行(entity.get歩行());
        eucEntity.set立ち上がり(entity.get立ち上がり());
        eucEntity.set片足での立位(entity.get片足での立位());
        eucEntity.set洗身(entity.get洗身());
        eucEntity.setつめ切り(entity.getつめ切り());
        eucEntity.set視力(entity.get視力());
        eucEntity.set聴力(entity.get聴力());
        eucEntity.set移乗(entity.get移乗());
        eucEntity.set移動(entity.get移動());
        eucEntity.setえん下(entity.getえん下());
        eucEntity.set食事摂取(entity.get食事摂取());
        eucEntity.set排尿(entity.get排尿());
        eucEntity.set排便(entity.get排便());
        eucEntity.set口腔清潔(entity.get口腔清潔());
        eucEntity.set洗顔(entity.get洗顔());
        eucEntity.set整髪(entity.get整髪());
        eucEntity.set上衣の着脱(entity.get上衣の着脱());
        eucEntity.setズボン等の着脱(entity.getズボン等の着脱());
        eucEntity.set外出頻度(entity.get外出頻度());
        eucEntity.set意思の伝達(entity.get意思の伝達());
        eucEntity.set毎日の日課を理解(entity.get毎日の日課を理解());
        eucEntity.set生年月日をいう(entity.get生年月日をいう());
        eucEntity.set短期記憶(entity.get短期記憶());
        eucEntity.set自分の名前をいう(entity.get自分の名前をいう());
        eucEntity.set今の季節を理解(entity.get今の季節を理解());
        eucEntity.set場所の理解(entity.get場所の理解());
        eucEntity.set徘徊(entity.get徘徊());
        eucEntity.set外出して戻れない(entity.get外出して戻れない());
        eucEntity.set被害的(entity.get被害的());
        eucEntity.set作話(entity.get作話());
        eucEntity.set感情が不安定(entity.get感情が不安定());
        eucEntity.set昼夜逆転(entity.get昼夜逆転());
        eucEntity.set同じ話をする(entity.get同じ話をする());
        eucEntity.set大声を出す(entity.get大声を出す());
        eucEntity.set介護に抵抗(entity.get介護に抵抗());
        eucEntity.set落ち着きなし(entity.get落ち着きなし());
        eucEntity.set一人で出たがる(entity.get一人で出たがる());
        eucEntity.set収集癖(entity.get収集癖());
        eucEntity.set物や衣類を壊す(entity.get物や衣類を壊す());
        eucEntity.setひどい物忘れ(entity.getひどい物忘れ());
        eucEntity.set独り言独り笑い(entity.get独り言独り笑い());
        eucEntity.set自分勝手に行動する(entity.get自分勝手に行動する());
        eucEntity.set話がまとまらない(entity.get話がまとまらない());
        eucEntity.set薬の内服(entity.get薬の内服());
        eucEntity.set金銭の管理(entity.get金銭の管理());
        eucEntity.set日常の意思決定(entity.get日常の意思決定());
        eucEntity.set集団への不適応(entity.get集団への不適応());
        eucEntity.set買い物(entity.get買い物());
        eucEntity.set簡単な調理(entity.get簡単な調理());
        eucEntity.set点滴の管理(entity.get点滴の管理());
        eucEntity.set中心静脈栄養(entity.get中心静脈栄養());
        eucEntity.set透析(entity.get透析());
        eucEntity.setストーマの処置(entity.getストーマの処置());
        eucEntity.set酸素療法(entity.get酸素療法());
        eucEntity.setレスピレーター(entity.getレスピレーター());
        eucEntity.set気管切開の処置(entity.get気管切開の処置());
        eucEntity.set疼痛の看護(entity.get疼痛の看護());
        eucEntity.set経管栄養(entity.get経管栄養());
        eucEntity.setモニター測定(entity.getモニター測定());
        eucEntity.setじょくそうの処置(entity.getじょくそうの処置());
        eucEntity.setカテーテル(entity.getカテーテル());
    }

    private void set前回結果認定調査票調査項目(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIf09AEucEntity eucEntity) {
        eucEntity.set前回結果麻痺左上肢(entity.get前回結果麻痺左上肢());
        eucEntity.set前回結果麻痺左下肢(entity.get前回結果麻痺左下肢());
        eucEntity.set前回結果麻痺右上肢(entity.get前回結果麻痺右上肢());
        eucEntity.set前回結果麻痺右下肢(entity.get前回結果麻痺右下肢());
        eucEntity.set前回結果麻痺その他(entity.get前回結果麻痺その他());
        eucEntity.set前回結果拘縮肩関節(entity.get前回結果拘縮肩関節());
        eucEntity.set前回結果拘縮股関節(entity.get前回結果拘縮股関節());
        eucEntity.set前回結果拘縮膝関節(entity.get前回結果拘縮膝関節());
        eucEntity.set前回結果拘縮その他(entity.get前回結果拘縮その他());
        eucEntity.set前回結果寝返り(entity.get前回結果寝返り());
        eucEntity.set前回結果起き上がり(entity.get前回結果起き上がり());
        eucEntity.set前回結果座位保持(entity.get前回結果座位保持());
        eucEntity.set前回結果両足での立位(entity.get前回結果両足での立位());
        eucEntity.set前回結果歩行(entity.get前回結果歩行());
        eucEntity.set前回結果立ち上がり(entity.get前回結果立ち上がり());
        eucEntity.set前回結果片足での立位(entity.get前回結果片足での立位());
        eucEntity.set前回結果洗身(entity.get前回結果洗身());
        eucEntity.set前回結果つめ切り(entity.get前回結果つめ切り());
        eucEntity.set前回結果視力(entity.get前回結果視力());
        eucEntity.set前回結果聴力(entity.get前回結果聴力());
        eucEntity.set前回結果移乗(entity.get前回結果移乗());
        eucEntity.set前回結果移動(entity.get前回結果移動());
        eucEntity.set前回結果えん下(entity.get前回結果えん下());
        eucEntity.set前回結果食事摂取(entity.get前回結果食事摂取());
        eucEntity.set前回結果排尿(entity.get前回結果排尿());
        eucEntity.set前回結果排便(entity.get前回結果排便());
        eucEntity.set前回結果口腔清潔(entity.get前回結果口腔清潔());
        eucEntity.set前回結果洗顔(entity.get前回結果洗顔());
        eucEntity.set前回結果整髪(entity.get前回結果整髪());
        eucEntity.set前回結果上衣の着脱(entity.get前回結果上衣の着脱());
        eucEntity.set前回結果ズボン等の着脱(entity.get前回結果ズボン等の着脱());
        eucEntity.set前回結果外出頻度(entity.get前回結果外出頻度());
        eucEntity.set前回結果意思の伝達(entity.get前回結果意思の伝達());
        eucEntity.set前回結果毎日の日課を理解(entity.get前回結果毎日の日課を理解());
        eucEntity.set前回結果生年月日をいう(entity.get前回結果生年月日をいう());
        eucEntity.set前回結果短期記憶(entity.get前回結果短期記憶());
        eucEntity.set前回結果自分の名前をいう(entity.get前回結果自分の名前をいう());
        eucEntity.set前回結果今の季節を理解(entity.get前回結果今の季節を理解());
        eucEntity.set前回結果場所の理解(entity.get前回結果場所の理解());
        eucEntity.set前回結果徘徊(entity.get前回結果徘徊());
        eucEntity.set前回結果外出して戻れない(entity.get前回結果外出して戻れない());
        eucEntity.set前回結果被害的(entity.get前回結果被害的());
        eucEntity.set前回結果作話(entity.get前回結果作話());
        eucEntity.set前回結果感情が不安定(entity.get前回結果感情が不安定());
        eucEntity.set前回結果昼夜逆転(entity.get前回結果昼夜逆転());
        eucEntity.set前回結果同じ話をする(entity.get前回結果同じ話をする());
        eucEntity.set前回結果大声を出す(entity.get前回結果大声を出す());
        eucEntity.set前回結果介護に抵抗(entity.get前回結果介護に抵抗());
        eucEntity.set前回結果落ち着きなし(entity.get前回結果落ち着きなし());
        eucEntity.set前回結果一人で出たがる(entity.get前回結果一人で出たがる());
        eucEntity.set前回結果収集癖(entity.get前回結果収集癖());
        eucEntity.set前回結果物や衣類を壊す(entity.get前回結果物や衣類を壊す());
        eucEntity.set前回結果ひどい物忘れ(entity.get前回結果ひどい物忘れ());
        eucEntity.set前回結果独り言独り笑い(entity.get前回結果独り言独り笑い());
        eucEntity.set前回結果自分勝手に行動する(entity.get前回結果自分勝手に行動する());
        eucEntity.set前回結果話がまとまらない(entity.get前回結果話がまとまらない());
        eucEntity.set前回結果薬の内服(entity.get前回結果薬の内服());
        eucEntity.set前回結果金銭の管理(entity.get前回結果金銭の管理());
        eucEntity.set前回結果日常の意思決定(entity.get前回結果日常の意思決定());
        eucEntity.set前回結果集団への不適応(entity.get前回結果集団への不適応());
        eucEntity.set前回結果買い物(entity.get前回結果買い物());
        eucEntity.set前回結果簡単な調理(entity.get前回結果簡単な調理());
        eucEntity.set前回結果点滴の管理(entity.get前回結果点滴の管理());
        eucEntity.set前回結果中心静脈栄養(entity.get前回結果中心静脈栄養());
        eucEntity.set前回結果透析(entity.get前回結果透析());
        eucEntity.set前回結果ストーマの処置(entity.get前回結果ストーマの処置());
        eucEntity.set前回結果酸素療法(entity.get前回結果酸素療法());
        eucEntity.set前回結果レスピレーター(entity.get前回結果レスピレーター());
        eucEntity.set前回結果気管切開の処置(entity.get前回結果気管切開の処置());
        eucEntity.set前回結果疼痛の看護(entity.get前回結果疼痛の看護());
        eucEntity.set前回結果経管栄養(entity.get前回結果経管栄養());
        eucEntity.set前回結果モニター測定(entity.get前回結果モニター測定());
        eucEntity.set前回結果じょくそうの処置(entity.get前回結果じょくそうの処置());
        eucEntity.set前回結果カテーテル(entity.get前回結果カテーテル());
    }

    private void set前回結果介護給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIf09AEucEntity eucEntity) {
        if (介護給付サービス.equals(entity.get前回結果サービス区分コード())) {
            eucEntity.set前回結果訪問介護ホームヘルプサービス(entity.get前回介護訪問介護ホームヘルプ());
            eucEntity.set前回結果訪問入浴介護(entity.get前回介護訪問入浴介護());
            eucEntity.set前回結果訪問看護(entity.get前回介護訪問看護());
            eucEntity.set前回結果訪問リハビリテーション(entity.get前回介護訪問リハビリテーション());
            eucEntity.set前回結果居宅療養管理指導(entity.get前回介護居宅療養管理指導());
            eucEntity.set前回結果通所介護デイサービス(entity.get前回介護通所介護デイサービス());
            eucEntity.set前回結果通所リハビリテーション(entity.get介護通所リハビリテーションデイケア());
            eucEntity.set前回結果短期入所生活介護ショートステイ(entity.get前回介護短期入所生活介護());
            eucEntity.set前回結果短期入所療養介護(entity.get前回介護短期入所療養介護());
            eucEntity.set前回結果特定施設入居者生活介護(entity.get前回介護特定施設入居者生活介護());
            eucEntity.set前回結果福祉用具貸与(entity.get前回介護福祉用具貸与());
            eucEntity.set前回結果特定福祉用具販売(entity.get前回介護特定福祉用具販売());
            eucEntity.set前回結果住宅改修介護給付(entity.get前回住宅改修介護給付());
            eucEntity.set前回結果夜間対応型訪問介護(entity.get前回介護夜間対応型訪問介護());
            eucEntity.set前回結果認知症対応型通所介護(entity.get前回介護認知症対応型通所介護());
            eucEntity.set前回結果小規模多機能型居宅介護(entity.get前回介護小規模多機能型居宅介護());
            eucEntity.set前回結果認知症対応型共同生活介護グループホーム(entity.get前回介護グループホーム());
            eucEntity.set前回結果地域密着型特定施設入居者生活介護(entity.get前回介護施設入居者生活介護());
            eucEntity.set前回結果地域密着型介護老人福祉施設入所者生活介護(entity.get前回老人福祉施設入所者生活介護());
        } else {
            eucEntity.set前回結果訪問介護ホームヘルプサービス(項目);
            eucEntity.set前回結果訪問入浴介護(項目);
            eucEntity.set前回結果訪問看護(項目);
            eucEntity.set前回結果訪問リハビリテーション(項目);
            eucEntity.set前回結果居宅療養管理指導(項目);
            eucEntity.set前回結果通所介護デイサービス(項目);
            eucEntity.set前回結果通所リハビリテーション(項目);
            eucEntity.set前回結果短期入所生活介護ショートステイ(項目);
            eucEntity.set前回結果短期入所療養介護(項目);
            eucEntity.set前回結果特定施設入居者生活介護(項目);
            eucEntity.set前回結果福祉用具貸与(項目);
            eucEntity.set前回結果特定福祉用具販売(項目);
            eucEntity.set前回結果住宅改修介護給付(項目);
            eucEntity.set前回結果夜間対応型訪問介護(項目);
            eucEntity.set前回結果認知症対応型通所介護(項目);
            eucEntity.set前回結果小規模多機能型居宅介護(項目);
            eucEntity.set前回結果認知症対応型共同生活介護グループホーム(項目);
            eucEntity.set前回結果地域密着型特定施設入居者生活介護(項目);
            eucEntity.set前回結果地域密着型介護老人福祉施設入所者生活介護(項目);
        }
    }

    private void set前回結果予防給付サービス(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity,
            IchijihanteiSumidataIf09AEucEntity eucEntity) {
        if (予防給付サービス.equals(entity.get前回結果サービス区分コード())) {
            eucEntity.set前回結果訪問介護ホームヘルプサービス(entity.get前回予防訪問介護ホームヘルプ());
            eucEntity.set前回結果訪問入浴介護(entity.get前回予防訪問入浴介護());
            eucEntity.set前回結果訪問看護(entity.get前回予防訪問看護());
            eucEntity.set前回結果訪問リハビリテーション(entity.get前回予防訪問リハビリテーション());
            eucEntity.set前回結果居宅療養管理指導(entity.get前回予防居宅療養管理指導());
            eucEntity.set前回結果通所介護デイサービス(entity.get前回予防通所介護デイサービス());
            eucEntity.set前回結果短期入所生活介護ショートステイ(entity.get前回予防短期入所生活介護());
            eucEntity.set前回結果短期入所療養介護(entity.get前回予防短期入所療養介護());
            eucEntity.set前回結果特定施設入居者生活介護(entity.get前回予防特定施設入居者生活介護());
            eucEntity.set前回結果福祉用具貸与(entity.get前回予防福祉用具貸与());
            eucEntity.set前回結果特定福祉用具販売(entity.get前回予防特定福祉用具販売());
            eucEntity.set前回結果住宅改修介護給付(entity.get前回住宅改修予防給付());
            eucEntity.set前回結果認知症対応型通所介護(entity.get前回予防認知症対応型通所介護());
            eucEntity.set前回結果小規模多機能型居宅介護(entity.get前回予防小規模多機能型居宅介護());
            eucEntity.set前回結果認知症対応型共同生活介護グループホーム(entity.get前回予防グループホーム());
        } else {
            eucEntity.set前回結果訪問介護ホームヘルプサービス(項目);
            eucEntity.set前回結果訪問入浴介護(項目);
            eucEntity.set前回結果訪問看護(項目);
            eucEntity.set前回結果訪問リハビリテーション(項目);
            eucEntity.set前回結果居宅療養管理指導(項目);
            eucEntity.set前回結果通所介護デイサービス(項目);
            eucEntity.set前回結果短期入所生活介護ショートステイ(項目);
            eucEntity.set前回結果短期入所療養介護(項目);
            eucEntity.set前回結果特定施設入居者生活介護(項目);
            eucEntity.set前回結果福祉用具貸与(項目);
            eucEntity.set前回結果特定福祉用具販売(項目);
            eucEntity.set前回結果住宅改修介護給付(項目);
            eucEntity.set前回結果認知症対応型通所介護(項目);
            eucEntity.set前回結果小規模多機能型居宅介護(項目);
            eucEntity.set前回結果認知症対応型共同生活介護グループホーム(項目);
        }
    }

    /**
     * アクセスログを出力するメッソドです。
     *
     * @param 被保険者番号 RString
     */
    public void getアクセスログ(RString 被保険者番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(被保険者番号));
    }

    private PersonalData toPersonalData(RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    /**
     * 出力件数を取得するメッソドです。
     *
     * @param 出力件数 出力件数
     * @return RString
     */
    public RString get出力件数(Decimal 出力件数) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
        return builder.toRString();
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @param paramter IchijihanteiSumidataIftProcessParamter
     * @return List<RString> 出力条件List
     */
    public List<RString> get出力条件(IchijihanteiSumidataIftProcessParamter paramter) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(paramter.get日付指定());
        if (項目.equals(paramter.get日付指定())) {
            jokenBuilder.append(new RString("【日付指定】　申請日"));
            出力条件List.add(jokenBuilder.toRString());
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(new RString("【申請日From】"));
            jokenBuilder.append(new FlexibleDate(paramter.get申請日From()).wareki().toDateString());
            出力条件List.add(jokenBuilder.toRString());
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(new RString("申請日To"));
            jokenBuilder.append(new FlexibleDate(paramter.get申請日To()).wareki().toDateString());
            出力条件List.add(jokenBuilder.toRString());
        }
        if (予防給付サービス.equals(paramter.get日付指定())) {
            jokenBuilder.append(new RString("【日付指定】　一次判定日"));
            出力条件List.add(jokenBuilder.toRString());
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(new RString("【一次判定日From】"));
            jokenBuilder.append(new FlexibleDate(paramter.get一次判定日From()).wareki().toDateString());
            出力条件List.add(jokenBuilder.toRString());
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(new RString("【一次判定日To】"));
            jokenBuilder.append(new FlexibleDate(paramter.get一次判定日To()).wareki().toDateString());
            出力条件List.add(jokenBuilder.toRString());
        }
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }

    private RString nullchck(RString ogj) {
        if (!RString.isNullOrEmpty(ogj)) {
            return new FlexibleDate(ogj).wareki().toDateString();
        }
        return RString.EMPTY;

    }
}
