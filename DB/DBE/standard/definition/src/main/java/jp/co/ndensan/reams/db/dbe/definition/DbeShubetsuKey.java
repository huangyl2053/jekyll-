/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;

/**
 * 認定支援業務で使用される、コードマスタの種別キーを管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public final class DbeShubetsuKey {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private DbeShubetsuKey() {
    }
    /**
     * 状態像の種別キーです。
     */
    public static final CodeShubetsu 状態像;
    /**
     * 認定申請区分（申請時）の種別キーです。
     */
    public static final CodeShubetsu 認定申請区分_申請時;
    /**
     * 認定申請区分（法令）の種別キーです。
     */
    public static final CodeShubetsu 認定申請区分_法令;
    /**
     * 取下げ区分の種別キーです。
     */
    public static final CodeShubetsu 取下げ区分;
    /**
     * 認定申請有効区分の種別キーです。
     */
    public static final CodeShubetsu 認定申請有効区分;
    /**
     * 認定取消事由の種別キーです。
     */
    public static final CodeShubetsu 認定取消事由;
    /**
     * 認定処理延期事由の種別キーです。
     */
    public static final CodeShubetsu 認定処理延期事由;
    /**
     * 要介護状態区分の種別キーです。
     */
    public static final CodeShubetsu 要介護状態区分;
    /**
     * 要介護度変更の指標の種別キーです。
     */
    public static final CodeShubetsu 要介護度変更の指標;
    /**
     * 新要介護認定適用区分の種別キーです。
     */
    public static final CodeShubetsu 新要介護認定適用区分;
    /**
     * 指定サービス種類コードの種別キーです。
     */
    public static final CodeShubetsu 指定サービス種類コード;
    /**
     * 現在のサービス区分の種別キーです。
     */
    public static final CodeShubetsu 現在のサービス区分;
    /**
     * 障害高齢者自立度の種別キーです。
     */
    public static final CodeShubetsu 障害高齢者自立度;
    /**
     * 認知症高齢者自立度の種別キーです。
     */
    public static final CodeShubetsu 認知症高齢者自立度;
    /**
     * 現在の状況の種別キーです。
     */
    public static final CodeShubetsu 現在の状況;
    /**
     * 状態の安定性の種別キーです。
     */
    public static final CodeShubetsu 状態の安定性;
    /**
     * 住宅改修の種別キーです。
     */
    public static final CodeShubetsu 住宅改修;
    /**
     * 運動能力の低下していない認知症高齢者の指標の種別キーです。
     */
    public static final CodeShubetsu 運動能力の低下していない認知症高齢者の指標;
    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価の種別キーです。
     */
    public static final CodeShubetsu 認知症高齢者の日常生活自立度の蓋然性評価;
    /**
     * 認知機能及び状態安定性から推定される給付区分の種別キーです。
     */
    public static final CodeShubetsu 認知機能及び状態安定性から推定される給付区分;
    /**
     * 推定される給付区分の種別キーです。
     */
    public static final CodeShubetsu 推定される給付区分;
    /**
     * 直近事由マスタの種別キーです。
     */
    public static final CodeShubetsu 直近事由マスタ;
    /**
     * 一次判定変更の際の検証指標の種別キーです。
     */
    public static final CodeShubetsu 一次判定変更の際の検証指標;
    /**
     * 一次判定用要介護状態区分の種別キーです。
     */
    public static final CodeShubetsu 一次判定用要介護状態区分;
    /**
     * 一次判定警告の種別キーです。
     */
    public static final CodeShubetsu 一次判定警告;
    /**
     * 要介護認定審査会優先振分区分の種別キーです。
     */
    public static final CodeShubetsu 要介護認定審査会優先振分区分;
    /**
     * 審査会地区の種別キーです。
     */
    public static final CodeShubetsu 審査会地区;
    /**
     * 合議体長区分の種別キーです。
     */
    public static final CodeShubetsu 合議体長区分;
    /**
     * 会場の種別キーです。
     */
    public static final CodeShubetsu 会場;
    /**
     * 認定審査員区分の種別キーです。
     */
    public static final CodeShubetsu 認定審査員区分;
    /**
     * 医師区分の種別キーです。
     */
    public static final CodeShubetsu 医師区分;
    /**
     * 資格の種別キーです。
     */
    public static final CodeShubetsu 資格;
    /**
     * 認定調査区分の種別キーです。
     */
    public static final CodeShubetsu 認定調査区分;
    /**
     * 認定調査・施設利用区分の種別キーです。
     */
    public static final CodeShubetsu 認定調査_施設利用区分;
    /**
     * 調査区分の種別キーです。
     */
    public static final CodeShubetsu 調査区分;
    /**
     * 認定調査依頼区分の種別キーです。
     */
    public static final CodeShubetsu 認定調査依頼区分;
    /**
     * 実施場所の種別キーです。
     */
    public static final CodeShubetsu 実施場所;
    /**
     * 調査委託区分の種別キーです。
     */
    public static final CodeShubetsu 調査委託区分;
    /**
     * 申請代行区分の種別キーです。
     */
    public static final CodeShubetsu 申請代行区分;
    /**
     * 提出代行種別の種別キーです。
     */
    public static final CodeShubetsu 提出代行種別;
    /**
     * 厚労省IF識別コードの種別キーです。
     */
    public static final CodeShubetsu 厚労省IF識別コード;

    static {
        状態像 = new CodeShubetsu("0001");
        認定申請区分_申請時 = new CodeShubetsu("0004");
        認定申請区分_法令 = new CodeShubetsu("0005");
        取下げ区分 = new CodeShubetsu("0006");
        認定申請有効区分 = new CodeShubetsu("0007");
        認定取消事由 = new CodeShubetsu("0008");
        認定処理延期事由 = new CodeShubetsu("0009");
        要介護状態区分 = new CodeShubetsu("0010");
        要介護度変更の指標 = new CodeShubetsu("0011");
        新要介護認定適用区分 = new CodeShubetsu("0012");
        指定サービス種類コード = new CodeShubetsu("0013");
        現在のサービス区分 = new CodeShubetsu("0014");
        障害高齢者自立度 = new CodeShubetsu("0015");
        認知症高齢者自立度 = new CodeShubetsu("0016");
        現在の状況 = new CodeShubetsu("0017");
        状態の安定性 = new CodeShubetsu("0018");
        住宅改修 = new CodeShubetsu("0019");
        運動能力の低下していない認知症高齢者の指標 = new CodeShubetsu("0020");
        認知症高齢者の日常生活自立度の蓋然性評価 = new CodeShubetsu("0021");
        認知機能及び状態安定性から推定される給付区分 = new CodeShubetsu("0022");
        推定される給付区分 = new CodeShubetsu("0023");
        直近事由マスタ = new CodeShubetsu("0024");
        一次判定変更の際の検証指標 = new CodeShubetsu("0027");
        一次判定用要介護状態区分 = new CodeShubetsu("0028");
        一次判定警告 = new CodeShubetsu("0029");
        要介護認定審査会優先振分区分 = new CodeShubetsu("0030");
        審査会地区 = new CodeShubetsu("0031");
        合議体長区分 = new CodeShubetsu("0032");
        会場 = new CodeShubetsu("0033");
        認定審査員区分 = new CodeShubetsu("0034");
        医師区分 = new CodeShubetsu("0035");
        資格 = new CodeShubetsu("0036");
        認定調査区分 = new CodeShubetsu("0037");
        認定調査_施設利用区分 = new CodeShubetsu("0038");
        調査区分 = new CodeShubetsu("0039");
        認定調査依頼区分 = new CodeShubetsu("0040");
        実施場所 = new CodeShubetsu("0041");
        調査委託区分 = new CodeShubetsu("0042");
        申請代行区分 = new CodeShubetsu("0043");
        提出代行種別 = new CodeShubetsu("0044");
        厚労省IF識別コード = new CodeShubetsu("0045");
    }
}
