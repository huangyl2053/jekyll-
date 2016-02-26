/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.kaigohokentokubetukaikeikeirijyokyoregist;

import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyoHokokuNenpoShoriName;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 処理日付管理マスタを管理するビジネスです。
 */
public class KaigoHokenShoriDateKanri {

    private final KaigoHokenShoriDateKanriEntity 処理日付管理マスタ;

    /**
     * コンストラクタです。<br/>
     *
     * @param 処理日付管理マスタ 処理日付管理マスタ
     * @link KaigoHokenShoriDateKanriEntity}より{@link KaigoHokenShoriDateKanri}を生成します。
     *
     * @param 処理日付管理マスタ @link KaigoHokenShoriDateKanriEntity}
     */
    public KaigoHokenShoriDateKanri(KaigoHokenShoriDateKanriEntity 処理日付管理マスタ) {
        this.処理日付管理マスタ = 処理日付管理マスタ;
    }

    /**
     * コンストラクタです。<br/>
     *
     */
    public KaigoHokenShoriDateKanri() {
        this.処理日付管理マスタ = new KaigoHokenShoriDateKanriEntity();
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param サブ業務コード
     * @param 市町村コード
     * @param 処理名
     * @param 処理枝番
     * @param 年度
     * @param 年度内連番
     * @param 基準年月日
     * @param 基準日時
     * @param 対象開始年月日
     * @param 対象終了年月日
     * @param 対象開始日時
     * @param 対象終了日時
     */
    public KaigoHokenShoriDateKanri(SubGyomuCode サブ業務コード, LasdecCode 市町村コード,
            JigyoHokokuNenpoShoriName 処理名, RString 処理枝番, FlexibleYear 年度, RString 年度内連番,
            FlexibleDate 基準年月日, RDateTime 基準日時, FlexibleDate 対象開始年月日,
            FlexibleDate 対象終了年月日, YMDHMS 対象開始日時, YMDHMS 対象終了日時) {
        this.処理日付管理マスタ = new KaigoHokenShoriDateKanriEntity(サブ業務コード, 市町村コード, 処理名, 処理枝番,
                年度, 年度内連番, 基準年月日, 基準日時, 対象開始年月日, 対象終了年月日, 対象開始日時, 対象終了日時);
    }

    /**
     * 処理日付管理マスタを返します。
     *
     * @return 処理日付管理マスタ
     */
    public KaigoHokenShoriDateKanriEntity get処理日付管理マスタ() {
        return 処理日付管理マスタ;
    }

    /**
     * 対象終了日時します。
     *
     * @return 対象終了日時
     */
    public YMDHMS get対象終了日時() {
        return 処理日付管理マスタ.get対象終了日時();
    }

    /**
     * 対象開始日時します。
     *
     * @return 対象開始日時
     */
    public YMDHMS get対象開始日時() {
        return 処理日付管理マスタ.get対象開始日時();
    }

    /**
     * 対象終了年月日します。
     *
     * @return 対象終了年月日
     */
    public FlexibleDate get対象終了年月日() {
        return 処理日付管理マスタ.get対象終了年月日();
    }

    /**
     * 対象開始年月日します。
     *
     * @return 対象開始年月日
     */
    public FlexibleDate get対象開始年月日() {
        return 処理日付管理マスタ.get対象開始年月日();
    }

    /**
     * 基準日時します。
     *
     * @return 基準日時
     */
    public RDateTime get基準日時() {
        return 処理日付管理マスタ.get基準日時();
    }

    /**
     * 基準年月日します。
     *
     * @return 基準年月日
     */
    public FlexibleDate get基準年月日() {
        return 処理日付管理マスタ.get基準年月日();
    }

    /**
     * 年度を返します。
     *
     * @return 年度
     */
    public FlexibleYear get年度() {
        return 処理日付管理マスタ.get年度();
    }

    /**
     * 年度内連番します。
     *
     * @return 年度内連番
     */
    public RString get年度内連番() {
        return 処理日付管理マスタ.get年度内連番();
    }

    /**
     * 処理枝番を返します。
     *
     * @return 処理枝番
     */
    public RString get処理枝番() {
        return 処理日付管理マスタ.get処理枝番();
    }

    /**
     * 処理名を返します。
     *
     * @return 処理名
     */
    public JigyoHokokuNenpoShoriName get処理名() {
        return 処理日付管理マスタ.get処理名();
    }

    /**
     * サブ業務コードを返します。
     *
     * @return サブ業務コード
     */
    public SubGyomuCode getサブ業務コード() {
        return 処理日付管理マスタ.getサブ業務コード();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return 処理日付管理マスタ.get市町村コード();
    }
}
