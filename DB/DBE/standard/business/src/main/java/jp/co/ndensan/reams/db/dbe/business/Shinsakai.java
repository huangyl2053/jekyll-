package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 審査会を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class Shinsakai {

    private final ShinsakaiDetail 審査会情報;
    private final ShinsakaiWariateIinList 割当委員List;

    /**
     * 審査会情報と割当委員のListを受け取り、インスタンスを生成します<br/>
     * 引数から渡された審査会情報と、割当委員がそれぞれ持つ審査会情報が一致していない場合、例外が発生します。
     *
     * @param 審査会情報 審査会情報
     * @param 割当委員List 割当委員List
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     * @throws IllegalArgumentException 審査会情報と、割当委員それぞれが持つ審査会情報が一致しない場合
     */
    public Shinsakai(ShinsakaiDetail 審査会情報, ShinsakaiWariateIinList 割当委員List)
            throws NullPointerException, IllegalArgumentException {
        requireNonNull(審査会情報, Messages.E00003.replace("審査会情報", getClass().getName()).getMessage());
        requireNonNull(割当委員List, Messages.E00003.replace("割当委員List", getClass().getName()).getMessage());

        for (ShinsakaiWariateIin 割当委員 : 割当委員List) {
            if (!割当委員.get審査会情報().equals(審査会情報)) {
                throw new IllegalArgumentException(Messages.E00013.replace("割当委員が持つ審査会の情報", "すべて一致").getMessage());
            }
        }

        this.審査会情報 = 審査会情報;
        this.割当委員List = 割当委員List;
    }

    /**
     * 審査会情報を返します。
     *
     * @return 審査会情報
     */
    public ShinsakaiDetail get審査会情報() {
        return 審査会情報;
    }

    /**
     * 審査会割当委員Listを返します。
     *
     * @return 審査会割当委員List
     */
    public ShinsakaiWariateIinList get割当委員List() {
        return 割当委員List;
    }
}
